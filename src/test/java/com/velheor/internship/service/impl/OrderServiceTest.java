package com.velheor.internship.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.config.H2JpaConfig;
import com.velheor.internship.models.Order;
import com.velheor.internship.service.api.IOrderService;
import com.velheor.internship.service.api.ITruckCategoryService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {H2JpaConfig.class})
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
    "classpath:beforeTest.sql"})
class OrderServiceTest extends BaseTest {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ITruckCategoryService truckCategoryService;

    @Test
    void findByIdReturnsUser() {
        Order actual = orderService.findById(orderExpected.getId());

        assertEquals(orderExpected, actual);
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
        Order actual = orderService.create(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        orderExpected.setDatePickup(LocalDateTime.of(2020, 2, 3, 11, 30));
        orderExpected.setDateDelivery(LocalDateTime.of(2021, 3, 3, 11, 30));
        Order actual = orderService.update(orderExpected);

        assertEquals(orderExpected, actual);
    }

    @Test
    void getAll() {
        List<Order> expectedOrders = Arrays.asList(orderExpected, orderExistsInDB);

        List<Order> actualOrders = orderService.getAll();

        assertEquals(expectedOrders, actualOrders);
    }

    @Test
    void deleteCheckForNotFoundUserAfterDelete() {
        int expectedCount = orderService.getAll().size() - 1;
        orderService.delete(orderExpected);
        int actualCount = orderService.getAll().size();

        assertThrows(EntityNotFoundException.class,
            () -> orderService.findById(orderExpected.getId()));

        assertEquals(expectedCount, actualCount);
    }

    @Test
    @Transactional
    public void checkForCorrectDeleteManyToMany() {
        orderService.delete(orderService.findById(orderExpected.getId()));
        assertThrows(EntityNotFoundException.class,
            () -> orderService.findById(userExpected.getId()));
        assertEquals(truckCategoryExistsInDB,
            truckCategoryService.findById(truckCategoryExistsInDB.getId()));
    }
}