package com.velheor.internship.controllers;

import com.velheor.internship.BaseWebTest;
import com.velheor.internship.dto.TruckViewDTO;
import com.velheor.internship.exception.ErrorMessage;
import com.velheor.internship.mappers.TruckMapper;
import com.velheor.internship.mappers.TruckMapperImpl;
import com.velheor.internship.models.enums.ETruckCategory;
import com.velheor.internship.service.TruckService;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;

import static com.velheor.internship.utils.TestUtils.TEST_UUID;
import static com.velheor.internship.utils.TestUtils.TRUCK1;
import static com.velheor.internship.utils.TestUtils.TRUCK2;
import static com.velheor.internship.utils.TestWebUtils.TRUCK_VIEW_DTO1;
import static com.velheor.internship.utils.TestWebUtils.TRUCK_VIEW_DTO2;
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

public class TruckControllerTest extends BaseWebTest {
    private final String truck_url = "/trucks/";
    private TruckService truckService;
    private TruckController truckController;

    public TruckControllerTest() {
        setUp(() -> {
            truckService = mock(TruckService.class);
            TruckMapper truckMapper = new TruckMapperImpl();
            truckController = new TruckController(truckService, truckMapper);
            return truckController;
        });
    }

    @Test
    void findById() throws Exception {
        when(truckService.findById(TRUCK1.getId())).thenReturn(TRUCK1);
        mockMvc.perform(get(truck_url + TRUCK1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(TRUCK_VIEW_DTO1)));
    }

    @Test
    void findByIdBadRequest() throws Exception {
        mockMvc.perform(get(truck_url + "notValidText")).andExpect(status().isBadRequest());
    }

    @Test
    void findByIdNotExists() throws Exception {
        when(truckService.findById(TEST_UUID)).thenThrow(new EntityNotFoundException());
        mockMvc.perform(get(truck_url + TEST_UUID))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof EntityNotFoundException));
    }

    @Test
    void getAll() throws Exception {
        when(truckService.getAll()).thenReturn(Arrays.asList(TRUCK1, TRUCK2));
        mockMvc.perform(get(truck_url))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(TRUCK_VIEW_DTO1, TRUCK_VIEW_DTO2))));
    }

    @Test
    void update() throws Exception {
        when(truckService.save(TRUCK1)).thenReturn(TRUCK1);

        mockMvc.perform(put(truck_url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(TRUCK_VIEW_DTO1)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(TRUCK_VIEW_DTO1)));
    }

    @Test
    void updateThrowHandleMethodArgumentNotValid() throws Exception {
        TruckViewDTO truck = new TruckViewDTO(TRUCK_VIEW_DTO1);
        truck.setTruckCategory(ETruckCategory.COVERED.toString());
        truck.setRegistrationNumber(null);

        String responseBody = mockMvc.perform(put(truck_url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(truck)))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException))
                .andReturn().getResponse().getContentAsString();
        ErrorMessage actual = objectMapper.readValue(responseBody, ErrorMessage.class);
        int countOfErrors = 1;
        assertThat(actual.getErrors().size()).isEqualTo(countOfErrors);
    }

    @Test
    void save() throws Exception {
        when(truckService.save(TRUCK1)).thenReturn(TRUCK1);
        mockMvc.perform(post(truck_url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(TRUCK_VIEW_DTO1)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(TRUCK_VIEW_DTO1)));
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete(truck_url + TRUCK1.getId())).andExpect(status().isNoContent());

        verify(truckService).deleteById(TRUCK1.getId());
    }
}
