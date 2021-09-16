package com.velheor.internship.controllers;

import com.velheor.internship.dto.CostViewDto;
import com.velheor.internship.mappers.CostMapper;
import com.velheor.internship.models.Cost;
import com.velheor.internship.service.CostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/costs")
@RequiredArgsConstructor
public class CostController {

    private final CostService costService;
    private final CostMapper costMapper;

    @GetMapping("/change/all")
    public Iterable<CostViewDto> changeAllCostCurrency(String to) {
        Iterable<Cost> costs = costService.changeAllCurrency(to);
        return costMapper.toCostViewDtoWithOrderViewDto(costs);
    }

    @GetMapping
    public Iterable<CostViewDto> getAll() {
        Iterable<Cost> costs = costService.findAll();
        return costMapper.toCostViewDtoWithOrderViewDto(costs);
    }
}
