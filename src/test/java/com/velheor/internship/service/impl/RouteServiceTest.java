package com.velheor.internship.service.impl;

import static com.velheor.internship.service.impl.TestUtils.EXPECTED_SIZE;
import static com.velheor.internship.service.impl.TestUtils.ORDER1;
import static com.velheor.internship.service.impl.TestUtils.ROUTE1;
import static com.velheor.internship.service.impl.TestUtils.ROUTE2;
import static com.velheor.internship.service.impl.TestUtils.TRUCK1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.models.Route;
import com.velheor.internship.service.RouteService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class RouteServiceTest implements BaseServiceTest {

    @Autowired
    private RouteService routeService;

    @Test
    void findByIdReturnsOrderAddress() {
        Route actual = routeService.findById(ROUTE1.getId());

        assertEquals(ROUTE1, actual);
    }

    @Test
    void findByIdThrowsEntityNotFoundException() {
        UUID notExistsId = UUID.fromString("12345678-9589-11eb-a8b3-0242ac130003");

        assertThrows(EntityNotFoundException.class,
            () -> routeService.findById(notExistsId));
    }

    @Test
    void create() {
        Route expected = new Route();
        expected.setAddressTo("MINSK");
        expected.setAddressFrom("HRODNO");
        expected.setOrder(ORDER1);

        Route actual = routeService.save(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        ROUTE1.setAddressFrom("KOROBCHICI");

        Route actual = routeService.save(ROUTE1);

        assertEquals(ROUTE1, actual);
    }

    @Test
    void getAll() {
        List<Route> expectedAll = List.of(ROUTE1, ROUTE2);
        List<Route> actualAll = new ArrayList<>();
        routeService.getAll().forEach(actualAll::add);

        assertEquals(expectedAll, actualAll);
    }

    @Test
    void deleteCheckForNotFoundOrderAddressAfterDelete() {
        routeService.deleteById(ROUTE1.getId());
        int actualSize = 0;
        for (Object i : routeService.getAll()) {
            actualSize++;
        }
        assertEquals(EXPECTED_SIZE, actualSize);

        assertThrows(EntityNotFoundException.class,
            () -> routeService.findById(TRUCK1.getId()));
    }
}