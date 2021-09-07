package com.velheor.internship.controllers;

import com.velheor.internship.dto.CostViewDto;
import com.velheor.internship.mappers.CostMapper;
import com.velheor.internship.models.Cost;
import com.velheor.internship.models.Currency;
import com.velheor.internship.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;
    private final CostMapper costMapper;

    @GetMapping("/update")
    public void updateRate() {
        currencyService.updateCurrentCurrenciesRates();
    }

    @GetMapping("/change")
    public Iterable<CostViewDto> changeCurrency(@RequestParam("currencies") HashMap<String,String> currencies) {
        Iterable<Cost> ordersWithUpdateCosts = currencyService.updateCurrentCurrenciesRates(currency);
        return costMapper.toCostViewDto(ordersWithUpdateCosts);
    }
}
