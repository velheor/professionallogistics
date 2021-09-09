package com.velheor.internship.utils;

import com.github.javafaker.Faker;
import com.velheor.internship.models.Cost;
import com.velheor.internship.models.Order;
import com.velheor.internship.models.enums.ETruckCategory;
import com.velheor.internship.service.CostService;
import com.velheor.internship.service.OrderService;
import com.velheor.internship.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class TestOrders {

    private final UserService userService;
    private final CostService costService;
    private final OrderService orderService;

    public void getOrderViewWithUserDtos() {
        List<Cost> costList = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < 100; i++) {
            Cost cost = new Cost();
            Order order = new Order();

            order.setShipper(userService.randomUser());

            order.setDatePickup(faker.date().past(10, TimeUnit.DAYS).toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime());

            order.setDateDelivery(faker.date().future(10, TimeUnit.DAYS).toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime());

            if (i % 2 == 0) {
                order.setTruckCategory(ETruckCategory.ALL_METAL);
            } else {
                order.setTruckCategory(ETruckCategory.COVERED);
            }

            costList.add(cost);
            orderService.save(order);
        }
        costService.saveAll(costList);
    }
}
