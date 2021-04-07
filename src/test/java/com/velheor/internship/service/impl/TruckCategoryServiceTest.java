package com.velheor.internship.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.config.H2JpaConfig;
import com.velheor.internship.models.TruckCategory;
import com.velheor.internship.service.api.ITruckCategoryService;
import java.util.Arrays;
import java.util.List;
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
class TruckCategoryServiceTest {

    @Autowired
    private ITruckCategoryService truckCategoryService;

    private TruckCategory expected;

    private Integer id;

    @BeforeEach
    void setUp() {
        expected = new TruckCategory();
        id = 0;
        expected.setId(id);
        expected.setName("COVERED");
    }

    @Test
    void findByIdReturnsTruckCategory() {
        TruckCategory actual = truckCategoryService.findById(id);
        assertEquals(expected, actual);
    }

    @Test
    void findByIdThrowsEntityNotFoundException() {
        int notExistsId = 999;
        assertThrows(EntityNotFoundException.class,
            () -> truckCategoryService.findById(notExistsId));
    }

    @Test
    void create() {
        TruckCategory expected = new TruckCategory();
        expected.setId(3);
        expected.setName("TANKER");
        expected.setTruckCategory(truckCategoryService.findById(id));

        TruckCategory actual = truckCategoryService.create(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        expected.setName("OVERCOVERED");
        TruckCategory actual = truckCategoryService.update(expected);
        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        TruckCategory truckCategory = new TruckCategory();
        truckCategory.setId(1);
        truckCategory.setName("ALL-METAL");
        truckCategory.setTruckCategory(expected);

        List<TruckCategory> expectedGetAll = Arrays.asList(expected, truckCategory);
        List<TruckCategory> actual = truckCategoryService.getAll();

        assertEquals(expectedGetAll, actual);
    }

    @Test
    void deleteCheckForNotFoundTruckCategoryAfterDelete() {
        truckCategoryService.delete(expected);
        assertThrows(EntityNotFoundException.class, () -> truckCategoryService.findById(id));
    }

    @Test
    void deleteCheckForCountAfterDelete() {
        int expectedCount = truckCategoryService.getAll().size() - 1;
        truckCategoryService.delete(expected);
        int actualCount = truckCategoryService.getAll().size();
        assertEquals(expectedCount, actualCount);
    }
}