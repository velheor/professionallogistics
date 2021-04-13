package com.velheor.internship.service.impl;

import static com.velheor.internship.service.impl.TestUtils.EXPECTED_SIZE;
import static com.velheor.internship.service.impl.TestUtils.ORDER1;
import static com.velheor.internship.service.impl.TestUtils.STATUS1;
import static com.velheor.internship.service.impl.TestUtils.STATUS2;
import static com.velheor.internship.service.impl.TestUtils.STATUS_IGNORE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.velheor.internship.models.Status;
import com.velheor.internship.models.enums.EStatus;
import com.velheor.internship.service.StatusService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class StatusServiceTest extends BaseServiceTest {

    @Autowired
    private StatusService statusService;

    @Test
    void findById() {
        Status actual = statusService.findById(STATUS1.getId());

        assertThat(actual)
            .isEqualToIgnoringGivenFields(STATUS1, STATUS_IGNORE);
    }

    @Test
    void findByIdThrownEntityNotFoundException() {
        UUID notExistsId = UUID.fromString("74a07384-93b8-11eb-a8b3-0242ac130003");

        assertThatThrownBy(() -> statusService.findById(notExistsId))
            .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void create() {
        Status expected = new Status();
        expected.setName(EStatus.ENDED);
        expected.setStatusDate(LocalDateTime.of(2021, 1, 25, 11, 45));
        expected.setOrder(ORDER1);
        Status actual = statusService.save(expected);

        assertThat(actual)
            .isEqualToIgnoringGivenFields(expected, STATUS_IGNORE);
    }

    @Test
    void update() {
        Status expected = new Status(STATUS1);
        expected.setName(EStatus.CANCELED);
        Status actual = statusService.save(expected);

        assertThat(actual)
            .isEqualToIgnoringGivenFields(expected, STATUS_IGNORE);
    }

    @Test
    void getAll() {
        List<Status> expectedAll = List.of(STATUS1, STATUS2);
        List<Status> actualAll = new ArrayList<>();
        statusService.getAll().forEach(actualAll::add);

        assertThat(expectedAll).usingElementComparatorIgnoringFields(STATUS_IGNORE)
            .isEqualTo(actualAll);

    }

    @Test
    void deleteById() {
        statusService.deleteById(STATUS1.getId());

        int actualSize = 0;
        for (Object ignored : statusService.getAll()) {
            actualSize++;
        }

        assertThat(actualSize).isEqualTo(EXPECTED_SIZE);

        assertThatThrownBy(() -> statusService.findById(STATUS1.getId()))
            .isInstanceOf(EntityNotFoundException.class);
    }
}