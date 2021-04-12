package com.velheor.internship.service.impl;

import static com.velheor.internship.service.impl.UtilTest.EXPECTED_SIZE;
import static com.velheor.internship.service.impl.UtilTest.ORDER1;
import static com.velheor.internship.service.impl.UtilTest.ORDER2;
import static com.velheor.internship.service.impl.UtilTest.TRUCK1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.models.Order;
import com.velheor.internship.service.OrderService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class OrderServiceTest implements BaseServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    void findByIdReturnsUser() {
        Order actual = orderService.findById(ORDER1.getId());

        assertEquals(ORDER1, actual);
    }

    @Test
    void findByIdThrowsEntityNotFoundException() {
        UUID notExistsId = UUID.fromString("74a07384-93b8-11eb-a8b3-0242ac130003");

        assertThrows(EntityNotFoundException.class,
            () -> orderService.findById(notExistsId));
    }

    @Test
    void create() {
        Order expected = new Order();
        expected.setDatePickup(LocalDateTime.of(2021, 2, 3, 11, 30));
        expected.setDateDelivery(LocalDateTime.of(2021, 2, 10, 10, 0));
        expected.setPrice(new BigDecimal(1337));
        Order actual = orderService.save(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        ORDER1.setDatePickup(LocalDateTime.of(2020, 2, 3, 11, 30));
        ORDER1.setDateDelivery(LocalDateTime.of(2021, 3, 3, 11, 30));
        Order actual = orderService.save(ORDER1);

        assertEquals(ORDER1, actual);
    }

    @Test
    void getAll() {
        List<Order> expectedALL = Arrays.asList(ORDER1, ORDER2);
        List<Order> actualAll = new ArrayList<>();
        orderService.getAll().forEach(actualAll::add);

        assertEquals(expectedALL, actualAll);
    }

    @Test
    void deleteCheckForNotFoundUserAfterDelete() {
        orderService.deleteById(ORDER1.getId());
        int actualSize = 0;
        for (Object i : orderService.getAll()) {
            actualSize++;
        }
        assertEquals(EXPECTED_SIZE, actualSize);

        assertThrows(EntityNotFoundException.class,
            () -> orderService.findById(TRUCK1.getId()));
    }
}