package com.velheor.internship.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.velheor.internship.models.Load;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class LoadServiceTest extends BaseServiceTest {

    @Autowired
    private LoadService loadService;

    @Test
    void findById() {
        Load actual = loadService.findById(TestUtils.LOAD1.getId());

        assertThat(actual)
            .isEqualToIgnoringGivenFields(TestUtils.LOAD1, TestUtils.LOAD_IGNORE);
    }

    @Test
    void findByIdThrownEntityNotFoundException() {
        UUID notExistsId = UUID.fromString("74a07384-93b8-11eb-a8b3-0242ac130003");

        assertThatThrownBy(() -> loadService.findById(notExistsId))
            .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void create() {
        Load expected = new Load();
        expected.setName("FURNITURE");
        expected.setWeight(new BigDecimal("0.5"));
        expected.setDetails("Just furniture");
        expected.setOrder(TestUtils.ORDER1);
        Load actual = loadService.save(expected);

        assertThat(actual)
            .isEqualToIgnoringGivenFields(expected, TestUtils.LOAD_IGNORE);
    }

    @Test
    void update() {
        Load expected = new Load(TestUtils.LOAD1);
        expected.setName("Test");
        Load actual = loadService.save(expected);

        assertThat(actual)
            .isEqualToIgnoringGivenFields(expected, TestUtils.LOAD_IGNORE);
    }

    @Test
    void getAll() {
        List<Load> expectedAll = List.of(TestUtils.LOAD1, TestUtils.LOAD2);
        List<Load> actualAll = new ArrayList<>();
        loadService.getAll().forEach(actualAll::add);

        assertThat(expectedAll).usingElementComparatorIgnoringFields(TestUtils.LOAD_IGNORE)
            .isEqualTo(actualAll);

    }

    @Test
    void deleteById() {
        loadService.deleteById(TestUtils.LOAD1.getId());

        int actualSize = 0;
        for (Object ignored : loadService.getAll()) {
            actualSize++;
        }

        assertThat(actualSize).isEqualTo(TestUtils.EXPECTED_SIZE);

        assertThatThrownBy(() -> loadService.findById(TestUtils.LOAD1.getId()))
            .isInstanceOf(EntityNotFoundException.class);
    }
}