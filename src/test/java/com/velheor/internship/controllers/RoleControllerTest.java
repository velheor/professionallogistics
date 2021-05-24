package com.velheor.internship.controllers;

import com.velheor.internship.BaseWebTest;
import com.velheor.internship.dto.RoleViewDTO;
import com.velheor.internship.exception.ErrorMessage;
import com.velheor.internship.mappers.RoleMapper;
import com.velheor.internship.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.EntityNotFoundException;

import static com.velheor.internship.utils.TestUtils.ROLE1;
import static com.velheor.internship.utils.TestUtils.TEST_UUID;
import static com.velheor.internship.utils.TestWebUtils.ROLE_URL;
import static com.velheor.internship.utils.TestWebUtils.ROLE_VIEW_DTO1;
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
public class RoleControllerTest extends BaseWebTest {

    private RoleService roleService;
    private RoleController roleController;

    @Autowired
    public RoleControllerTest(RoleMapper roleMapper) {
        setUp(() -> {
            roleService = mock(RoleService.class);
            roleController = new RoleController(roleService, roleMapper);
            return roleController;
        });
    }

    @Test
    void findById() throws Exception {
        when(roleService.findById(ROLE1.getId())).thenReturn(ROLE1);
        mockMvc.perform(get(ROLE_URL + ROLE1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(ROLE_VIEW_DTO1)));
    }

    @Test
    void findByIdBadRequest() throws Exception {
        mockMvc.perform(get(ROLE_URL + "notValidText")).andExpect(status().isBadRequest());
    }

    @Test
    void findByIdNotExists() throws Exception {
        when(roleService.findById(TEST_UUID)).thenThrow(new EntityNotFoundException());
        mockMvc.perform(get(ROLE_URL + TEST_UUID))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof EntityNotFoundException));
    }

    @Test
    void update() throws Exception {
        when(roleService.save(ROLE1)).thenReturn(ROLE1);

        mockMvc.perform(put(ROLE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ROLE_VIEW_DTO1)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(ROLE_VIEW_DTO1)));
    }

    @Test
    void updateThrowHandleMethodArgumentNotValid() throws Exception {
        RoleViewDTO role = new RoleViewDTO(ROLE_VIEW_DTO1);

        role.setName(null);

        String responseBody = mockMvc.perform(put(ROLE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(role)))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException))
                .andReturn().getResponse().getContentAsString();
        ErrorMessage actual = objectMapper.readValue(responseBody, ErrorMessage.class);
        int countOfErrors = 1;
        assertThat(actual.getErrors().size()).isEqualTo(countOfErrors);
    }

    @Test
    void save() throws Exception {
        when(roleService.save(ROLE1)).thenReturn(ROLE1);
        mockMvc.perform(post(ROLE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ROLE_VIEW_DTO1)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(ROLE_VIEW_DTO1)));
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete(ROLE_URL + ROLE1.getId())).andExpect(status().isNoContent());

        verify(roleService).deleteById(ROLE1.getId());
    }
}
