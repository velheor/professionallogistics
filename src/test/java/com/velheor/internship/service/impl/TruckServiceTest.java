package com.velheor.internship.service.impl;

import static com.velheor.internship.service.impl.UtilTest.EXPECTED_SIZE;
import static com.velheor.internship.service.impl.UtilTest.TRUCK1;
import static com.velheor.internship.service.impl.UtilTest.TRUCK2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.models.Truck;
import com.velheor.internship.service.TruckService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class TruckServiceTest implements BaseServiceTest {

    @Autowired
    private TruckService truckService;

    @Test
    void findByIdReturnsTruck() {
        Truck actual = truckService.findById(TRUCK1.getId());

        assertEquals(TRUCK1, actual);
    }

    @Test
    void findByIdReturnsEntityNotFoundException() {
        UUID notExistsId = UUID.fromString("74a07384-93b8-11eb-a8b3-0242ac130003");

        assertThrows(EntityNotFoundException.class,
            () -> truckService.findById(notExistsId));
    }

    @Test
    void create() {
        Truck expected = new Truck();
        expected.setName("SCANIA");
        expected.setRegistrationNumber("66666-5");
        expected.setMaxWeight(new BigDecimal(10));
        Truck actual = truckService.save(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        TRUCK1.setName("DAF");
        TRUCK1.setMaxWeight(new BigDecimal(5));
        Truck actual = truckService.save(TRUCK1);

        assertEquals(TRUCK1, actual);
    }

    @Test
    void getAll() {
        List<Truck> expectedAll = List.of(TRUCK1, TRUCK2);
        List<Truck> actualAll = new ArrayList<>();
        truckService.getAll().forEach(actualAll::add);

        assertEquals(expectedAll, actualAll);
    }

    @Test
    void deleteById() {
        truckService.deleteById(TRUCK1.getId());
        int actualSize = 0;
        for (Object i : truckService.getAll()) {
            actualSize++;
        }
        assertEquals(EXPECTED_SIZE, actualSize);

        assertThrows(EntityNotFoundException.class,
            () -> truckService.findById(TRUCK1.getId()));

    }
}