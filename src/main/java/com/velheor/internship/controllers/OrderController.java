package com.velheor.internship.controllers;

import com.velheor.internship.dto.OrderViewDto;
import com.velheor.internship.mappers.OrderMapper;
import com.velheor.internship.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping("/{id}")
    public OrderViewDto findById(@PathVariable("id") UUID id) {
        return orderMapper.toOrderDto(orderService.findById(id));
    }

    @GetMapping
    public Iterable<OrderViewDto> getAll() {
        return orderMapper.toOrdersViewDto(orderService.getAll());
    }

    @PutMapping
    public OrderViewDto update(@Valid @RequestBody OrderViewDto orderViewDTO) {
        return orderMapper.toOrderDto(orderService.save(orderMapper.toOrder(orderViewDTO)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderViewDto save(@Valid @RequestBody OrderViewDto orderViewDTO) {
        orderService.save(orderMapper.toOrder(orderViewDTO));
        return orderViewDTO;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") UUID id) {
        orderService.deleteById(id);
    }
}
