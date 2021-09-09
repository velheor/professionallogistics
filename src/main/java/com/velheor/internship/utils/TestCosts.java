package com.velheor.internship.utils;

import com.github.javafaker.Faker;
import com.velheor.internship.models.Cost;
import com.velheor.internship.service.CostService;
import com.velheor.internship.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TestCosts {
    private final CostService costService;
    private final OrderService orderService;

    public void creatingTestData() {
        Faker faker = new Faker();
        List<Cost> costs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Cost cost = new Cost();
            cost.setCurrencyName("USD");
            cost.setAmount(BigDecimal.valueOf(faker.number().randomDouble(3, 1, 199)));
            cost.setOrder(orderService.getRandomOrder());
        }

    }
}
