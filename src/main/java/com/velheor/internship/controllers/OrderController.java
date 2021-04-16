package com.velheor.internship.controllers;

import com.velheor.internship.dto.OrderDTO;
import com.velheor.internship.mappers.OrderMapper;
import com.velheor.internship.service.OrderService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @GetMapping("/{id}")
    public OrderDTO findById(@PathVariable("id") UUID id) {
        return orderMapper.orderToOrderDto(orderService.findById(id));
    }

    @GetMapping
    public Iterable<OrderDTO> getAll() {
        return orderMapper.ordersToOrdersDto(orderService.getAll());
    }

    @PutMapping
    public OrderDTO update(@RequestBody OrderDTO OrderDTO) {
        orderService.save(orderMapper.orderDtoToOrder(OrderDTO));
        return OrderDTO;
    }

    @PostMapping
    public OrderDTO save(@RequestBody OrderDTO OrderDTO) {
        orderService.save(orderMapper.orderDtoToOrder(OrderDTO));
        return OrderDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        orderService.deleteById(id);
    }
}
