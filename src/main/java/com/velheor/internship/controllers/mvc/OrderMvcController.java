package com.velheor.internship.controllers.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.velheor.internship.mappers.OrderMapper;
import com.velheor.internship.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc")
public class OrderMvcController {

    private final static String ordersView = "orders";
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final ObjectMapper objectMapper;

    @GetMapping("/orders")
    @SneakyThrows
    public String getAllOrders(Model model) {
        model.addAttribute("orderJson", objectMapper.writeValueAsString(orderMapper.toOrdersViewDto(orderService.getAll())));
        return ordersView;
    }
}
