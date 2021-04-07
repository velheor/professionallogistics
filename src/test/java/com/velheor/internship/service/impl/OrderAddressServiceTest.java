package com.velheor.internship.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.config.H2JpaConfig;
import com.velheor.internship.models.OrderAddress;
import com.velheor.internship.service.api.IOrderAddressService;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {H2JpaConfig.class})
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
    "classpath:beforeTest.sql"})
class OrderAddressServiceTest extends BaseTest {

    @Autowired
    private IOrderAddressService orderAddressService;

    @Test
    void findByIdReturnsOrderAddress() {
        OrderAddress actual = orderAddressService.findById(orderAddressExpected.getId());

        assertEquals(orderAddressExpected, actual);
    }

    @Test
    void findByIdThrowsEntityNotFoundException() {
        UUID notExistsId = UUID.fromString("12345678-9589-11eb-a8b3-0242ac130003");

        assertThrows(EntityNotFoundException.class,
            () -> orderAddressService.findById(notExistsId));
    }

    @Test
    void create() {
        OrderAddress expected = new OrderAddress();
        expected.setAddressTo("MINSK");
        expected.setAddressFrom("HRODNO");
        expected.setOrder(orderExpected);

        OrderAddress actual = orderAddressService.create(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        orderAddressExpected.setAddressFrom("KOROBCHICI");

        OrderAddress actual = orderAddressService.update(orderAddressExpected);

        assertEquals(orderAddressExpected, actual);
    }

    @Test
    void getAll() {
        List<OrderAddress> expectedAll = List.of(orderAddressExpected, orderAddressExistInDB);

        List<OrderAddress> actualAll = orderAddressService.getAll();

        assertEquals(expectedAll, actualAll);
    }

    @Test
    void deleteCheckForNotFoundOrderAddressAfterDelete() {
        int expectedCount = orderAddressService.getAll().size() - 1;
        orderAddressService.delete(orderAddressExpected);
        int actualCount = orderAddressService.getAll().size();

        assertThrows(EntityNotFoundException.class,
            () -> orderAddressService.findById(orderAddressExpected.getId()));

        assertEquals(expectedCount, actualCount);
    }
}