package com.velheor.internship.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.config.H2JpaConfig;
import com.velheor.internship.models.TruckCategory;
import com.velheor.internship.service.api.ITruckCategoryService;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {H2JpaConfig.class})
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
    "classpath:beforeTest.sql"})
class TruckCategoryServiceTest extends BaseTest {

    @Autowired
    private ITruckCategoryService truckCategoryService;

    @Test
    void findByIdReturnsTruckCategory() {
        TruckCategory actual = truckCategoryService.findById(truckCategoryExpected.getId());

        assertEquals(truckCategoryExpected, actual);
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
        expected.setTruckCategory(truckCategoryService.findById(truckCategoryExpected.getId()));

        TruckCategory actual = truckCategoryService.create(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        TruckCategory expected = truckCategoryService.findById(truckCategoryExpected.getId());
        expected.setName("OVERCOVERED");
        TruckCategory actual = truckCategoryService.update(expected);

        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        List<TruckCategory> expectedGetAll = Arrays
            .asList(truckCategoryExpected, truckCategoryExistsInDB);
        List<TruckCategory> actual = truckCategoryService.getAll();

        assertEquals(expectedGetAll, actual);
    }

    @Test
    void delete() {
        int expectedCount = truckCategoryService.getAll().size() - 1;
        truckCategoryService.delete(truckCategoryExpected);
        int actualCount = truckCategoryService.getAll().size();

        assertThrows(EntityNotFoundException.class,
            () -> truckCategoryService.findById(truckCategoryExpected.getId()));

        assertEquals(expectedCount, actualCount);
    }
}