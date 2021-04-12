package com.velheor.internship.service.impl;

import static com.velheor.internship.service.impl.TestUtils.EXPECTED_SIZE;
import static com.velheor.internship.service.impl.TestUtils.ORDER1;
import static com.velheor.internship.service.impl.TestUtils.STATUS1;
import static com.velheor.internship.service.impl.TestUtils.STATUS2;
import static com.velheor.internship.service.impl.TestUtils.TRUCK1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.models.Status;
import com.velheor.internship.models.enums.EStatusHistory;
import com.velheor.internship.service.StatusService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class StatusServiceTest implements BaseServiceTest {

    @Autowired
    private StatusService statusService;

    @Test
    void findByIdReturnsStatusHistory() {
        Status actual = statusService.findById(STATUS1.getId());

        assertEquals(STATUS1, actual);
    }

    @Test
    void findByIdThrowsEntityNotFoundException() {
        UUID notExistsId = UUID.fromString("344444cc-958b-11eb-a8b3-0242ac130003");

        assertThrows(EntityNotFoundException.class,
            () -> statusService.findById(notExistsId));
    }

    @Test
    void create() {
        Status expected = new Status();
        expected.setId(UUID.fromString("377514cc-958b-11eb-a8b3-0242ac130003"));
        expected.setName(EStatusHistory.STARTED);
        expected.setStatusDate(LocalDateTime.of(2020, 2, 10, 12, 0));
        expected.setOrder(ORDER1);

        Status actual = statusService.save(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        Status expected = statusService.findById(STATUS1.getId());
        expected.setName(EStatusHistory.CANCELED);
        Status actual = statusService.save(expected);

        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        List<Status> expectedAll = List.of(STATUS1, STATUS2);
        List<Status> actualAll = new ArrayList<>();
        statusService.getAll().forEach(actualAll::add);

        assertEquals(expectedAll, actualAll);
    }

    @Test
    void delete() {
        statusService.deleteById(STATUS1.getId());
        int actualSize = 0;
        for (Object i : statusService.getAll()) {
            actualSize++;
        }
        assertEquals(EXPECTED_SIZE, actualSize);

        assertThrows(EntityNotFoundException.class,
            () -> statusService.findById(TRUCK1.getId()));
    }
}