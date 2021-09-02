package com.velheor.internship.controllers;

import com.velheor.internship.models.Rate;
import com.velheor.internship.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final RateService currencyService;

    @GetMapping
    public List<Rate> getAll() {
        return currencyService.getCurrentCurrency();
    }

    @GetMapping("/update")
    public void updateRate() {
        currencyService.updateCurrentRates();
    }
}
