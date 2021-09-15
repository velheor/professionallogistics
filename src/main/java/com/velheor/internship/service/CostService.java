package com.velheor.internship.service;

import com.velheor.internship.models.Cost;
import com.velheor.internship.models.Currency;
import com.velheor.internship.models.Rate;
import com.velheor.internship.repository.CostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CostService {

    private final CostRepository costRepository;
    private final CurrencyService currencyService;

    public Cost save(Cost cost) {
        return costRepository.save(cost);
    }

    public Iterable<Cost> findAll() {
        return costRepository.findAll();
    }

    public Iterable<Cost> saveAll(Iterable<Cost> costs) {
        return costRepository.saveAll(costs);
    }

    public Iterable<Cost> changeAllCurrency(String to) {
        Iterable<Cost> costs = costRepository.findAll();
        for (Cost cost : costs) {
            Rate calculatedRate = calculateRate(cost.getCurrencyName(), to);
            changeCost(calculatedRate, cost);
        }
        return costs;
    }

    private Rate calculateRate(String from, String to) {
        Rate rate = new Rate();
        rate.setName(to);
        BigDecimal amount = calculateExchangeRate(from, to);
        rate.setExchangeRate(amount);
        return rate;
    }

    private BigDecimal calculateExchangeRate(String from, String to) {
        Currency currency = currencyService.findLatestCurrency("EUR");
        Rate rateTo = findByName(to, currency.getRates());
        Rate rateFrom = findByName(from, currency.getRates());
        BigDecimal exchangeRateTo = rateTo.getExchangeRate();
        BigDecimal exchangeRateFrom = rateFrom.getExchangeRate();
        return exchangeRateTo.divide(exchangeRateFrom, 5, RoundingMode.HALF_DOWN);
    }

    private Cost changeCost(Rate rate, Cost cost) {
        BigDecimal exchangeRate = rate.getExchangeRate();
        cost.setCurrencyName(rate.getName());
        BigDecimal calculatedAmount = cost
                .getAmount()
                .multiply(exchangeRate)
                .setScale(2, RoundingMode.HALF_DOWN);
        cost.setAmount(calculatedAmount);
        return cost;
    }

    private Rate findByName(String name, List<Rate> rates) {
        return rates.stream()
                .filter(r -> r.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Don't find rate with " + name + "name"));
    }
}
