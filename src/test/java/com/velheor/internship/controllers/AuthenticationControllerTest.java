package com.velheor.internship.controllers;

import com.velheor.internship.BaseWebTest;
import com.velheor.internship.dto.AuthUserDto;
import com.velheor.internship.dto.UserViewDto;
import com.velheor.internship.exception.ErrorMessage;
import com.velheor.internship.mappers.RoleMapper;
import com.velheor.internship.mappers.UserMapper;
import com.velheor.internship.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static com.velheor.internship.utils.TestWebUtils.AUTH_URL;
import static com.velheor.internship.utils.TestWebUtils.AUTH_USER_DTO;
import static com.velheor.internship.utils.TestWebUtils.USER_VIEW_DTO1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AuthenticationControllerTest extends BaseWebTest {

    private UserService userService;

    @Autowired
    AuthenticationControllerTest(AuthenticationManager authenticationManager, UserMapper userMapper, RoleMapper roleMapper) {
        setUp(() -> {
            userService = mock(UserService.class);
            return new AuthenticationController(authenticationManager, userService, userMapper, roleMapper);
        });
    }

    @Test
    void authenticate() throws Exception {
        mockMvc.perform(post(AUTH_URL + "login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(AUTH_USER_DTO)))
                .andExpect(status().isOk());
    }

    @Test
    void authenticateThrowForbiddenException() throws Exception {
        AuthUserDto authUserDTO = new AuthUserDto(AUTH_USER_DTO);
        authUserDTO.setPassword("blablabla");
        mockMvc.perform(post(AUTH_URL + "login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(authUserDTO)))
                .andExpect(status().isForbidden());
    }

    @Test
    void signUp() throws Exception {
        String result = mockMvc.perform(post(AUTH_URL + "signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(USER_VIEW_DTO1)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        assertThat(result).isEqualTo("Check your email!");
    }

    @Test
    void signUpThrowHandleMethodArgumentNotValid() throws Exception {
        UserViewDto testUser = new UserViewDto(USER_VIEW_DTO1);
        testUser.setPassword("test");
        testUser.setPhoneNumber("+1234");

        String responseBody = mockMvc.perform(post(AUTH_URL + "signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testUser)))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException))
                .andReturn().getResponse().getContentAsString();
        ErrorMessage actual = objectMapper.readValue(responseBody, ErrorMessage.class);
        int countOfErrors = 2;
        assertThat(actual.getErrors().size()).isEqualTo(countOfErrors);
    }
}