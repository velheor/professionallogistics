package com.velheor.internship.controllers;

import com.velheor.internship.BaseWebTest;
import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.exception.ErrorMessage;
import com.velheor.internship.mappers.UserMapper;
import com.velheor.internship.mappers.UserMapperImpl;
import com.velheor.internship.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;

import static com.velheor.internship.utils.TestUtils.USER1;
import static com.velheor.internship.utils.TestUtils.USER2;
import static com.velheor.internship.utils.TestWebUtils.USER_VIEW_DTO1;
import static com.velheor.internship.utils.TestWebUtils.USER_VIEW_DTO2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WithMockUser(authorities = "ADMIN")
class UserControllerTest extends BaseWebTest {

    private final String user_url = "/users/";
    private UserService userService;
    private UserController userController;

    public UserControllerTest() {
        setUp(() -> {
            userService = mock(UserService.class);
            UserMapper userMapper = new UserMapperImpl();
            userController = new UserController(userService, userMapper);
            return userController;
        });
    }

    @Test
    void findById() throws Exception {
        when(userService.findById(USER1.getId())).thenReturn(USER1);
        mockMvc.perform(get(user_url + USER1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(USER_VIEW_DTO1)));
    }

    @Test
    void findByIdBadRequest() throws Exception {
        mockMvc.perform(get(user_url + "notValidText")).andExpect(status().isBadRequest());
    }

    @Test
    void findByIdNotExistsUser() throws Exception {
        mockMvc.perform(get(user_url + "415ab4a6-adaf-11eb-8529-0242ac130003"))
                .andExpect(status().isOk())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof EntityNotFoundException));
    }

    @Test
    void getAll() throws Exception {
        when(userService.getAll()).thenReturn(Arrays.asList(USER1, USER2));
        mockMvc.perform(get(user_url))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(USER_VIEW_DTO1, USER_VIEW_DTO2))));
    }

    @Test
    @WithMockUser(authorities = "USER")
    void getAllWithBadAuthorities() throws Exception {
        when(userService.getAll()).thenReturn(Arrays.asList(USER1, USER2));
        mockMvc.perform(get(user_url))
                .andExpect(status().isForbidden());
    }

    @Test
    void update() throws Exception {
        when(userService.save(USER1)).thenReturn(USER1);

        mockMvc.perform(put(user_url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(USER_VIEW_DTO1)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(USER_VIEW_DTO1)));
    }

    @Test
    void updateThrowHandleMethodArgumentNotValid() throws Exception {
        UserViewDTO testUser = new UserViewDTO(USER_VIEW_DTO1);
        testUser.setPassword("test");
        testUser.setPhoneNumber("+1234");

        String responseBody = mockMvc.perform(put(user_url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testUser)))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException))
                .andReturn().getResponse().getContentAsString();
        ErrorMessage actual = objectMapper.readValue(responseBody, ErrorMessage.class);
        int countOfErrors = 2;
        assertThat(actual.getErrors().size()).isEqualTo(countOfErrors);
    }

    @Test
    void save() throws Exception {
        when(userService.save(USER1)).thenReturn(USER1);
        mockMvc.perform(post(user_url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(USER_VIEW_DTO1)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(USER_VIEW_DTO1)));
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete(user_url + USER1.getId())).andExpect(status().isNoContent());

        verify(userService).deleteById(USER1.getId());
    }
}