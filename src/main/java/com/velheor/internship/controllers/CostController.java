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

    @GetMapping("/change/")
    public Iterable<CostViewDto> changeCostCurrency(String from, String to) {
        Iterable<Cost> costs = costService.changeCostCurrency(from, to);
        return costMapper.toCostViewDto(costs);
    }
}
