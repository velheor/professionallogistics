package com.velheor.internship.controllers;

import com.velheor.internship.BaseWebTest;
import com.velheor.internship.dto.OrderViewDTO;
import com.velheor.internship.dto.StatusViewDTO;
import com.velheor.internship.exception.ErrorMessage;
import com.velheor.internship.mappers.StatusMapperImpl;
import com.velheor.internship.service.StatusService;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.EntityNotFoundException;

import static com.velheor.internship.utils.TestUtils.STATUS1;
import static com.velheor.internship.utils.TestUtils.TEST_UUID;
import static com.velheor.internship.utils.TestWebUtils.STATUS_VIEW_DTO1;
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

public class StatusControllerTest extends BaseWebTest {
    private final String status_url = "/statuses/";
    private StatusService statusService;
    private StatusController statusController;

    public StatusControllerTest() {
        setUp(() -> {
            statusService = mock(StatusService.class);
            StatusMapperImpl statusMapper = new StatusMapperImpl();
            statusController = new StatusController(statusService, statusMapper);
            return statusController;
        });
    }

    @Test
    void findById() throws Exception {
        when(statusService.findById(STATUS1.getId())).thenReturn(STATUS1);
        mockMvc.perform(get(status_url + STATUS1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(STATUS_VIEW_DTO1)));
    }

    @Test
    void findByIdBadRequest() throws Exception {
        mockMvc.perform(get(status_url + "notValidText")).andExpect(status().isBadRequest());
    }

    @Test
    void findByIdNotExists() throws Exception {
        when(statusService.findById(TEST_UUID)).thenThrow(new EntityNotFoundException());
        mockMvc.perform(get(status_url + TEST_UUID))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof EntityNotFoundException));
    }

    @Test
    void update() throws Exception {
        when(statusService.save(STATUS1)).thenReturn(STATUS1);

        mockMvc.perform(put(status_url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(STATUS_VIEW_DTO1)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(STATUS_VIEW_DTO1)));
    }

    @Test
    void updateThrowHandleMethodArgumentNotValid() throws Exception {
        StatusViewDTO statusViewDTO = new StatusViewDTO(STATUS_VIEW_DTO1);

        statusViewDTO.setStatusDate(null);

        String responseBody = mockMvc.perform(put(status_url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(statusViewDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException))
                .andReturn().getResponse().getContentAsString();
        ErrorMessage actual = objectMapper.readValue(responseBody, ErrorMessage.class);
        int countOfErrors = 1;
        assertThat(actual.getErrors().size()).isEqualTo(countOfErrors);
    }

    @Test
    void save() throws Exception {
        when(statusService.save(STATUS1)).thenReturn(STATUS1);
        mockMvc.perform(post(status_url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(STATUS_VIEW_DTO1)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(STATUS_VIEW_DTO1)));
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete(status_url + STATUS1.getId())).andExpect(status().isNoContent());

        verify(statusService).deleteById(STATUS1.getId());
    }
}
