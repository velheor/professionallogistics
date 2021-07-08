package com.velheor.internship.controllers.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.velheor.internship.dto.OrderFilterDto;
import com.velheor.internship.mappers.OrderMapper;
import com.velheor.internship.models.Order;
import com.velheor.internship.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc")
public class OrderMvcController {

    private final static String ORDERS_VIEW = "orders";
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final ObjectMapper objectMapper;

    @GetMapping("/orders")
    @SneakyThrows
    public String getAllWithUsers(Model model) {
        Iterable<Order> orders = orderService.getAll();
        model.addAttribute("orderFilter", new OrderFilterDto());
        model.addAttribute("orderJson", objectMapper.writeValueAsString(orderMapper.toOrdersViewWithUserDto(orders)));
        return ORDERS_VIEW;
    }

    @GetMapping("/orders/{id}")
    @SneakyThrows
    public String getFullInfo(@PathVariable("id") UUID id, Model model) {
        Order order = orderService.findById(id);
        model.addAttribute("orderJson", objectMapper.writeValueAsString(orderMapper.toOrderDto(order)));
        return ORDERS_VIEW;
    }

    @PostMapping("/orders")
    @SneakyThrows
    public String getByParameters(@ModelAttribute("orderFilter") OrderFilterDto orderFilterDto, Model model) {
        Iterable<Order> orders = orderService.filterOrders(orderFilterDto);
        model.addAttribute("orderJson", objectMapper.writeValueAsString(orderMapper.toOrdersViewWithUserDto(orders)));
        return ORDERS_VIEW;
    }
}
