package com.velheor.internship.controllers;

import com.velheor.internship.dto.OrderViewDTO;
import com.velheor.internship.mappers.OrderMapper;
import com.velheor.internship.service.OrderService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping("/{id}")
    public OrderViewDTO findById(@PathVariable("id") UUID id) {
        return orderMapper.orderToOrderDto(orderService.findById(id));
    }

    @GetMapping
    public Iterable<OrderViewDTO> getAll() {
        return orderMapper.ordersToOrdersDto(orderService.getAll());
    }

    @PutMapping
    public OrderViewDTO update(@RequestBody OrderViewDTO OrderViewDTO) {
        orderService.save(orderMapper.orderDtoToOrder(OrderViewDTO));
        return OrderViewDTO;
    }

    @PostMapping
    public OrderViewDTO save(@RequestBody OrderViewDTO OrderViewDTO) {
        orderService.save(orderMapper.orderDtoToOrder(OrderViewDTO));
        return OrderViewDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        orderService.deleteById(id);
    }
}
