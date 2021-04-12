package com.velheor.internship.service.impl;

import static com.velheor.internship.service.impl.TestUtils.EXPECTED_SIZE;
import static com.velheor.internship.service.impl.TestUtils.LOAD1;
import static com.velheor.internship.service.impl.TestUtils.LOAD2;
import static com.velheor.internship.service.impl.TestUtils.ORDER2;
import static com.velheor.internship.service.impl.TestUtils.TRUCK1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.models.Load;
import com.velheor.internship.service.LoadService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class LoadServiceTest implements BaseServiceTest {

    @Autowired
    private LoadService loadService;

    @Test
    void findByIdReturnsLoad() {
        Load actual = loadService.findById(LOAD1.getId());

        assertEquals(LOAD1, actual);
    }

    @Test
    void findByThrowsEntityNotFoundException() {
        UUID notExistsId = UUID.fromString("12345678-958b-11eb-a8b3-0242ac130003");

        assertThrows(EntityNotFoundException.class, () -> loadService.findById(notExistsId));
    }

    @Test
    void create() {
        Load expected = new Load();
        expected.setName("CEMENT");
        expected.setWeight(new BigDecimal("1.5"));
        expected.setOrder(ORDER2);
        expected.setDetails("FOR BUILDING");
        Load actual = loadService.save(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        Load expected = loadService.findById(LOAD1.getId());
        expected.setName("VEGETABLES");

        Load actual = loadService.save(expected);

        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        List<Load> expectedAll = List.of(LOAD1, LOAD2);
        List<Load> actualAll = new ArrayList<>();
        loadService.getAll().forEach(actualAll::add);

        assertEquals(expectedAll, actualAll);
    }

    @Test
    void delete() {
        loadService.deleteById(LOAD1.getId());
        int actualSize = 0;
        for (Object i : loadService.getAll()) {
            actualSize++;
        }
        assertEquals(EXPECTED_SIZE, actualSize);

        assertThrows(EntityNotFoundException.class,
            () -> loadService.findById(TRUCK1.getId()));
    }
}