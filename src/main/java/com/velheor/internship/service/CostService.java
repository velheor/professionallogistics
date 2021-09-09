package com.velheor.internship.service;

import com.velheor.internship.models.Cost;
import com.velheor.internship.models.Rate;
import com.velheor.internship.repository.CostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CostService {

    private final CostRepository costRepository;
    private final RateService rateService;

    public Iterable<Cost> findAll() {
        return costRepository.findAll();
    }

    public Iterable<Cost> saveAll(Iterable<Cost> costs) {
        return costRepository.saveAll(costs);
    }

    public Iterable<Cost> changeCostCurrency(String from, String to) {
        Rate rate = rateService.findByNameAndCurrencyName(from, to);
        Iterable<Cost> costs = costRepository.findAll();
        return changeCost(rate, costs);
    }

    private Iterable<Cost> changeCost(Rate rate, Iterable<Cost> costs) {
        BigDecimal exchangeRate = rate.getExchangeRate();
        costs.forEach(cost -> cost.setAmount(cost.getAmount().multiply(exchangeRate)));
        return costs;
    }

    public Cost save(Cost cost) {
        return costRepository.save(cost);
    }
}
