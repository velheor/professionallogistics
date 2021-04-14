package com.velheor.internship.service;

import static com.velheor.internship.utils.TestUtils.EXPECTED_SIZE;
import static com.velheor.internship.utils.TestUtils.LOAD1;
import static com.velheor.internship.utils.TestUtils.LOAD2;
import static com.velheor.internship.utils.TestUtils.LOAD_IGNORE;
import static com.velheor.internship.utils.TestUtils.ORDER1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.velheor.internship.BaseTest;
import com.velheor.internship.models.Load;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class LoadServiceTest extends BaseTest {

    @Autowired
    private LoadService loadService;

    @Test
    void findById() {
        Load actual = loadService.findById(LOAD1.getId());

        assertThat(actual).isEqualToIgnoringGivenFields(LOAD1, LOAD_IGNORE);
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
        expected.setOrder(ORDER1);
        Load actual = loadService.save(expected);

        assertThat(actual).isEqualToIgnoringGivenFields(expected, LOAD_IGNORE);
    }

    @Test
    void update() {
        Load expected = new Load(LOAD1);
        expected.setName("Test");
        Load actual = loadService.save(expected);

        assertThat(actual).isEqualToIgnoringGivenFields(expected, LOAD_IGNORE);
    }

    @Test
    void getAll() {
        List<Load> expectedAll = List.of(LOAD1, LOAD2);
        List<Load> actualAll = new ArrayList<>();
        loadService.getAll().forEach(actualAll::add);

        assertThat(expectedAll).usingElementComparatorIgnoringFields(LOAD_IGNORE)
            .isEqualTo(actualAll);

    }

    @Test
    void deleteById() {
        loadService.deleteById(LOAD1.getId());

        int actualSize = 0;
        for (Object ignored : loadService.getAll()) {
            actualSize++;
        }

        assertThat(actualSize).isEqualTo(EXPECTED_SIZE);

        assertThatThrownBy(() -> loadService.findById(LOAD1.getId()))
            .isInstanceOf(EntityNotFoundException.class);
    }
}