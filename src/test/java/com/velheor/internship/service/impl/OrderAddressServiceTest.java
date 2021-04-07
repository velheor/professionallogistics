package com.velheor.internship.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.config.H2JpaConfig;
import com.velheor.internship.models.OrderAddress;
import com.velheor.internship.service.api.IOrderAddressService;
import com.velheor.internship.service.api.IOrderService;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {H2JpaConfig.class})
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
    "classpath:beforeTest.sql"})
class OrderAddressServiceTest {

    @Autowired
    private IOrderAddressService orderAddressService;

    @Autowired
    private IOrderService orderService;

    private OrderAddress expected;

    private UUID id;

    @BeforeEach
    void setUp() {
        id = UUID.fromString("a12ee7be-9589-11eb-a8b3-0242ac130003");
        expected = new OrderAddress();
        expected.setId(id);
        expected.setAddressTo("HRODNO");
        expected.setAddressFrom("MINSK");
        expected.setOrder(
            orderService.findById(UUID.fromString("377514cc-958b-11eb-a8b3-0242ac130003")));
    }

    @Test
    void findByIdReturnsOrderAddress() {
        OrderAddress actual = orderAddressService.findById(id);
        assertEquals(expected, actual);
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
        expected.setOrder(
            orderService.findById(UUID.fromString("377514cc-958b-11eb-a8b3-0242ac130003")));

        OrderAddress actual = orderAddressService.create(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        expected.setAddressFrom("KOROBCHICI");

        OrderAddress actual = orderAddressService.update(expected);

        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        OrderAddress orderAddress = new OrderAddress();
        orderAddress.setId(UUID.fromString("a678774e-9589-11eb-a8b3-0242ac130003"));
        orderAddress.setAddressTo("VITEBSK");
        orderAddress.setAddressFrom("BREST");
        orderAddress.setOrder(
            orderService.findById(UUID.fromString("3a424170-958b-11eb-a8b3-0242ac130003")));

        List<OrderAddress> expectedAll = List.of(expected, orderAddress);

        List<OrderAddress> actualAll = orderAddressService.getAll();

        assertEquals(expectedAll, actualAll);
    }

    @Test
    void deleteCheckForNotFoundOrderAddressAfterDelete() {
        orderAddressService.delete(expected);
        assertThrows(EntityNotFoundException.class, () -> orderAddressService.findById(id));
    }

    @Test
    void deleteCheckForCountAfterDelete() {
        int expectedCount = orderAddressService.getAll().size() - 1;
        orderAddressService.delete(expected);
        int actualCount = orderAddressService.getAll().size();
        assertEquals(expectedCount, actualCount);
    }
}