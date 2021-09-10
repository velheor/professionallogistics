package com.velheor.internship.service;

import com.velheor.internship.models.Cost;
import com.velheor.internship.models.Rate;
import com.velheor.internship.repository.CostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
            Rate rate = rateService.findByNameAndCurrencyName(cost.getCurrencyName(), to);
            changeCost(rate, cost);
        }
        return costs;
    }

    public Iterable<Cost> changeCostCurrency(String from, String to) {
        Rate rate = rateService.findByNameAndCurrencyName(from, to);
        Iterable<Cost> costs = costRepository.findAll();
        return changeCost(rate, costs);
    }

    private List<Cost> changeCost(Rate rate, Iterable<Cost> costs) {
        List<Cost> costList = new ArrayList<>();
        for (Cost cost : costs) {
            costList.add(changeCost(rate, cost));
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
