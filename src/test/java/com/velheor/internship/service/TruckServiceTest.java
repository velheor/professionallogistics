package com.velheor.internship.service;

import static com.velheor.internship.utils.TestUtils.EXPECTED_SIZE;
import static com.velheor.internship.utils.TestUtils.TRUCK1;
import static com.velheor.internship.utils.TestUtils.TRUCK2;
import static com.velheor.internship.utils.TestUtils.TRUCK_IGNORE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.velheor.internship.BaseTest;
import com.velheor.internship.models.Truck;
import com.velheor.internship.models.enums.ETruckCategory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class TruckServiceTest extends BaseTest {

    @Autowired
    private TruckService truckService;

    @Test
    void findById() {
        Truck actual = truckService.findById(TRUCK1.getId());

        assertThat(actual).isEqualToIgnoringGivenFields(TRUCK1, TRUCK_IGNORE);
    }

    @Test
    void findByIdThrownEntityNotFoundException() {
        UUID notExistsId = UUID.fromString("74a07384-93b8-11eb-a8b3-0242ac130003");

        assertThatThrownBy(() -> truckService.findById(notExistsId))
            .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void create() {
        Truck expected = new Truck();
        expected.setName("SCANIA");
        expected.setRegistrationNumber("66666-5");
        expected.setMaxWeight(new BigDecimal("10"));
        expected.setTruckCategory(ETruckCategory.ALL_METAL);
        Truck actual = truckService.save(expected);

        assertThat(actual).isEqualToIgnoringGivenFields(expected, TRUCK_IGNORE);
    }

    @Test
    void update() {
        Truck expected = new Truck(TRUCK1);
        expected.setName("DAF");
        expected.setMaxWeight(new BigDecimal("5.0"));
        Truck actual = truckService.save(expected);

        assertThat(actual).isEqualToIgnoringGivenFields(expected, TRUCK_IGNORE);
    }

    @Test
    void getAll() {
        List<Truck> expectedAll = List.of(TRUCK1, TRUCK2);
        List<Truck> actualAll = new ArrayList<>();
        truckService.getAll().forEach(actualAll::add);

        assertThat(expectedAll).usingElementComparatorIgnoringFields(TRUCK_IGNORE)
            .isEqualTo(actualAll);
    }

    @Test
    void deleteById() {
        truckService.deleteById(TRUCK1.getId());

        int actualSize = 0;
        for (Object ignored : truckService.getAll()) {
            actualSize++;
        }

        assertThat(actualSize).isEqualTo(EXPECTED_SIZE);

        assertThatThrownBy(() -> truckService.findById(TRUCK1.getId()))
            .isInstanceOf(EntityNotFoundException.class);
    }
}