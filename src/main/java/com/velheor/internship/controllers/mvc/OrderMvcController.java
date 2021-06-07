package com.velheor.internship.controllers.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.velheor.internship.mappers.OrderMapper;
import com.velheor.internship.models.Order;
import com.velheor.internship.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

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
    public String getAllOrdersWithUsers(Model model) {
        Iterable<Order> users = orderService.getAll();
        model.addAttribute("orderJsons", objectMapper.writeValueAsString(orderMapper.toOrdersViewWithUserDto(users)));
        return ordersView;
    }

    @GetMapping("/orders/{id}")
    @SneakyThrows
    public String getFullInfoAboutOrder(@PathVariable("id") UUID id, Model model) {
        Order order = orderService.findById(id);
        model.addAttribute("orderJson", objectMapper.writeValueAsString(orderMapper.toOrderDto(order)));
        return ordersView;
    }
}
