package com.velheor.internship.controllers;

import com.velheor.internship.BaseWebTest;
import com.velheor.internship.dto.LoadViewDTO;
import com.velheor.internship.exception.ErrorMessage;
import com.velheor.internship.mappers.LoadMapperImpl;
import com.velheor.internship.service.LoadService;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.EntityNotFoundException;

import java.math.BigDecimal;

import static com.velheor.internship.utils.TestUtils.LOAD1;
import static com.velheor.internship.utils.TestUtils.TEST_UUID;
import static com.velheor.internship.utils.TestWebUtils.LOAD_VIEW_DTO1;
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

public class LoadControllerTest extends BaseWebTest {
    private final String load_url = "/loads/";
    private LoadService loadService;
    private LoadController loadController;

    public LoadControllerTest() {
        setUp(() -> {
            loadService = mock(LoadService.class);
            LoadMapperImpl loadMapper = new LoadMapperImpl();
            loadController = new LoadController(loadService, loadMapper);
            return loadController;
        });
    }

    @Test
    void findById() throws Exception {
        when(loadService.findById(LOAD1.getId())).thenReturn(LOAD1);
        mockMvc.perform(get(load_url + LOAD1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(LOAD_VIEW_DTO1)));
    }

    @Test
    void findByIdBadRequest() throws Exception {
        mockMvc.perform(get(load_url + "notValidText")).andExpect(status().isBadRequest());
    }

    @Test
    void findByIdNotExists() throws Exception {
        when(loadService.findById(TEST_UUID)).thenThrow(new EntityNotFoundException());
        mockMvc.perform(get(load_url + TEST_UUID))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof EntityNotFoundException));
    }

    @Test
    void update() throws Exception {
        when(loadService.save(LOAD1)).thenReturn(LOAD1);

        mockMvc.perform(put(load_url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(LOAD_VIEW_DTO1)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(LOAD_VIEW_DTO1)));
    }

    @Test
    void updateThrowHandleMethodArgumentNotValid() throws Exception {
        LoadViewDTO load = new LoadViewDTO(LOAD_VIEW_DTO1);

        load.setWeight(new BigDecimal("0"));

        String responseBody = mockMvc.perform(put(load_url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(load)))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException))
                .andReturn().getResponse().getContentAsString();
        ErrorMessage actual = objectMapper.readValue(responseBody, ErrorMessage.class);
        int countOfErrors = 1;
        assertThat(actual.getErrors().size()).isEqualTo(countOfErrors);
    }

    @Test
    void save() throws Exception {
        when(loadService.save(LOAD1)).thenReturn(LOAD1);
        mockMvc.perform(post(load_url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(LOAD_VIEW_DTO1)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(LOAD_VIEW_DTO1)));
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete(load_url + LOAD1.getId())).andExpect(status().isNoContent());

        verify(loadService).deleteById(LOAD1.getId());
    }
}
