package com.velheor.internship.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.config.H2JpaConfig;
import com.velheor.internship.models.Load;
import com.velheor.internship.service.api.ILoadService;
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
class LoadServiceTest extends BaseTest {

    @Autowired
    private ILoadService loadService;

    @Test
    void findByIdReturnsLoad() {
        Load actual = loadService.findById(loadExpected.getId());

        assertEquals(loadExpected, actual);
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
        expected.setOrder(orderTest);
        expected.setDetails("FOR BUILDING");
        Load actual = loadService.create(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        Load expected = loadService.findById(loadExpected.getId());
        expected.setName("VEGETABLES");

        Load actual = loadService.update(expected);

        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        List<Load> expectedAll = List.of(loadExpected, loadTest);
        List<Load> actualAll = loadService.getAll();

        assertEquals(expectedAll, actualAll);
    }

    @Test
    void delete() {
        int expectedCount = loadService.getAll().size() - 1;
        loadService.delete(loadExpected);
        int actualCount = loadService.getAll().size();

        assertThrows(EntityNotFoundException.class,
            () -> loadService.findById(loadExpected.getId()));

        assertEquals(expectedCount, actualCount);
    }
}