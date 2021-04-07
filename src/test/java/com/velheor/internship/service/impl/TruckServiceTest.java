package com.velheor.internship.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.config.H2JpaConfig;
import com.velheor.internship.models.Truck;
import com.velheor.internship.service.api.ITruckCategoryService;
import com.velheor.internship.service.api.ITruckService;
import java.math.BigDecimal;
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
class TruckServiceTest {

    @Autowired
    private ITruckService truckService;

    @Autowired
    private ITruckCategoryService truckCategoryService;

    private Truck expected;

    private UUID id;

    @BeforeEach
    void setUp() {
        expected = new Truck();
        id = UUID.fromString("a0a81b2e-9725-11eb-a8b3-0242ac130003");
        expected.setId(id);
        expected.setName("VOLVO");
        expected.setRegistrationNumber("1234VA-5");
        expected.setMaxWeight(new BigDecimal(10));
        expected.setTruckCategory(truckCategoryService.findById(1));
    }

    @Test
    void findByIdReturnsTruck() {
        Truck actual = truckService.findById(id);
        assertEquals(expected, actual);
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
        expected.setTruckCategory(truckCategoryService.findById(1));
        Truck actual = truckService.create(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        expected.setName("DAF");
        expected.setMaxWeight(new BigDecimal(5));
        Truck actual = truckService.update(expected);

        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        Truck truck1 = new Truck();
        truck1.setId(UUID.fromString("886c0c76-9727-11eb-a8b3-0242ac130003"));
        truck1.setName("SCANIA");
        truck1.setRegistrationNumber("2345AV-6");
        truck1.setMaxWeight(new BigDecimal(11));
        truck1.setTruckCategory(truckCategoryService.findById(1));

        List<Truck> expectedTrucks = List.of(expected, truck1);
        List<Truck> actualTrucks = truckService.getAll();

        assertEquals(expectedTrucks, actualTrucks);
    }

    @Test
    void deleteCheckForNotFoundUserAfterDelete() {
        truckService.delete(expected);
        assertThrows(EntityNotFoundException.class, () -> truckService.findById(id));
    }

    @Test
    void deleteCheckForCountAfterDelete() {
        int expectedCount = truckService.getAll().size() - 1;
        truckService.delete(expected);
        int actualCount = truckService.getAll().size();
        assertEquals(expectedCount, actualCount);
    }
}