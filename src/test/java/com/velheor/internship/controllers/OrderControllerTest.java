package com.velheor.internship.controllers;

import com.velheor.internship.BaseWebTest;
import com.velheor.internship.dto.OrderViewDTO;
import com.velheor.internship.exception.ErrorMessage;
import com.velheor.internship.mappers.OrderMapperImpl;
import com.velheor.internship.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

import static com.velheor.internship.utils.TestUtils.ORDER1;
import static com.velheor.internship.utils.TestUtils.TEST_UUID;
import static com.velheor.internship.utils.TestWebUtils.ORDER_VIEW_DTO1;
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

public class OrderControllerTest extends BaseWebTest {
    private final String order_url = "/orders/";
    private OrderService orderService;
    private OrderController orderController;

    public OrderControllerTest() {
        setUp(() -> {
            orderService = mock(OrderService.class);
            OrderMapperImpl orderMapper = new OrderMapperImpl();
            orderController = new OrderController(orderService, orderMapper);
            return orderController;
        });
    }

    @Test
    void findById() throws Exception {
        when(orderService.findById(ORDER1.getId())).thenReturn(ORDER1);
        mockMvc.perform(get(order_url + ORDER1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(ORDER_VIEW_DTO1)));
    }

    @Test
    void findByIdBadRequest() throws Exception {
        mockMvc.perform(get(order_url + "notValidText")).andExpect(status().isBadRequest());
    }

    @Test
    void findByIdNotExists() throws Exception {
        when(orderService.findById(TEST_UUID)).thenThrow(new EntityNotFoundException());
        mockMvc.perform(get(order_url + TEST_UUID))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof EntityNotFoundException));
    }

    @Test
    void update() throws Exception {
        when(orderService.save(ORDER1)).thenReturn(ORDER1);

        mockMvc.perform(put(order_url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ORDER_VIEW_DTO1)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(ORDER_VIEW_DTO1)));
    }

    @Test
    void updateThrowHandleMethodArgumentNotValid() throws Exception {
        OrderViewDTO order = new OrderViewDTO(ORDER_VIEW_DTO1);

        order.setPrice(new BigDecimal("0"));

        String responseBody = mockMvc.perform(put(order_url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException))
                .andReturn().getResponse().getContentAsString();
        ErrorMessage actual = objectMapper.readValue(responseBody, ErrorMessage.class);
        int countOfErrors = 1;
        assertThat(actual.getErrors().size()).isEqualTo(countOfErrors);
    }

    @Test
    void save() throws Exception {
        when(orderService.save(ORDER1)).thenReturn(ORDER1);
        mockMvc.perform(post(order_url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ORDER_VIEW_DTO1)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(ORDER_VIEW_DTO1)));
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete(order_url + ORDER1.getId())).andExpect(status().isNoContent());

        verify(orderService).deleteById(ORDER1.getId());
    }
}
