package com.velheor.internship.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.config.H2JpaConfig;
import com.velheor.internship.models.Truck;
import com.velheor.internship.service.api.ITruckService;
import java.math.BigDecimal;
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
class TruckServiceTest extends BaseTest {

    @Autowired
    private ITruckService truckService;

    @Test
    void findByIdReturnsTruck() {
        Truck actual = truckService.findById(truckExpected.getId());

        assertEquals(truckExpected, actual);
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
        expected.setTruckCategory(truckCategoryTest);
        Truck actual = truckService.create(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        truckExpected.setName("DAF");
        truckExpected.setMaxWeight(new BigDecimal(5));
        Truck actual = truckService.update(truckExpected);

        assertEquals(truckExpected, actual);
    }

    @Test
    void getAll() {
        List<Truck> expectedTrucks = List.of(truckExpected, truckTest);
        List<Truck> actualTrucks = truckService.getAll();

        assertEquals(expectedTrucks, actualTrucks);
    }

    @Test
    void delete() {
        int expectedCount = truckService.getAll().size() - 1;
        truckService.delete(truckExpected);
        int actualCount = truckService.getAll().size();

        assertThrows(EntityNotFoundException.class,
            () -> truckService.findById(truckExpected.getId()));

        assertEquals(expectedCount, actualCount);
    }
}