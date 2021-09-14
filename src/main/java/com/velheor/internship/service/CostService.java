package com.velheor.internship.service;

import com.velheor.internship.models.Cost;
import com.velheor.internship.models.Rate;
import com.velheor.internship.repository.CostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

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

    public Iterable<Cost> changeAllCurrency(String to) {
        Iterable<Cost> costs = costRepository.findAll();
        for (Cost cost : costs) {
            BigDecimal exchangeRate = calculateRate(cost.getCurrencyName(), to);

            changeCost(exchangeRate, cost);
        }
        return costs;
    }

    public Iterable<Cost> changeCostCurrency(String from, String to) {
        Rate rate = rateService.findByNameAndCurrencyName(from, to);
        Iterable<Cost> costs = costRepository.findAll();
        return changeCost(rate, costs);
    }

    private BigDecimal calculateRate(String from, String to) {
        Rate rate = rateService.findByNameAndCurrencyName(from, "EUR");
        Rate rate1 = rateService.findByNameAndCurrencyName(to, "EUR");
        return rate.getExchangeRate().divide(rate1.getExchangeRate(),2, RoundingMode.HALF_UP);
    }

    private List<Cost> changeCost(BigDecimal exchangeCost, Iterable<Cost> costs) {
        List<Cost> costList = new ArrayList<>();
        for (Cost cost : costs) {
            costList.add(changeCost(exchangeCost, cost));
        }
        return costList;
    }

    private Cost changeCost(Rate rate, Cost cost) {
        BigDecimal exchangeRate = rate.getExchangeRate();
        cost.setCurrencyName(rate.getCurrency().getName());
        cost.setAmount(cost.getAmount().multiply(exchangeRate));
        return cost;
    }

    public Cost save(Cost cost) {
        return costRepository.save(cost);
    }
}
