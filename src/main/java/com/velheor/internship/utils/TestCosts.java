package com.velheor.internship.utils;

import com.github.javafaker.Faker;
import com.velheor.internship.models.Cost;
import com.velheor.internship.models.Order;
import com.velheor.internship.service.CostService;
import com.velheor.internship.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TestCosts {
    private final CostService costService;
    private final OrderService orderService;

    @Transactional
    public void createTestData() {
        Faker faker = new Faker();
        List<Cost> costs = new ArrayList<>();
        Iterable<Order> orders = orderService.getAll();
        for (Order order : orders) {
            Cost cost = new Cost();
            String currency;
            int random = faker.random().nextInt(100);
            if (random % 3 == 0) {
                currency = "USD";
            } else if (random % 2 == 0) {
                currency = "EUR";
            } else {
                currency = "RUB";
            }
            cost.setCurrencyName(currency);
            cost.setAmount(BigDecimal.valueOf(faker.number().randomDouble(3, 1, 199)));
            cost.setOrder(order);
            costs.add(cost);
        }
        costService.saveAll(costs);
    }
}
