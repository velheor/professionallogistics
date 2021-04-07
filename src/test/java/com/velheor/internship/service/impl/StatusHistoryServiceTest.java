package com.velheor.internship.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.config.H2JpaConfig;
import com.velheor.internship.models.StatusHistory;
import com.velheor.internship.models.enums.EStatusHistory;
import com.velheor.internship.service.api.IStatusHistoryService;
import java.time.LocalDateTime;
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
class StatusHistoryServiceTest extends BaseTest {

    @Autowired
    private IStatusHistoryService statusHistoryService;

    @Test
    void findByIdReturnsStatusHistory() {
        StatusHistory actual = statusHistoryService.findById(statusHistoryExpected.getId());

        assertEquals(statusHistoryExpected, actual);
    }

    @Test
    void findByIdThrowsEntityNotFoundException() {
        UUID notExistsId = UUID.fromString("344444cc-958b-11eb-a8b3-0242ac130003");

        assertThrows(EntityNotFoundException.class,
            () -> statusHistoryService.findById(notExistsId));
    }

    @Test
    void create() {
        StatusHistory expected = new StatusHistory();
        expected.setId(UUID.fromString("377514cc-958b-11eb-a8b3-0242ac130003"));
        expected.setName(EStatusHistory.STARTED);
        expected.setStatusDate(LocalDateTime.of(2020, 2, 10, 12, 0));
        expected.setOrder(orderExpected);

        StatusHistory actual = statusHistoryService.create(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        StatusHistory expected = statusHistoryService.findById(statusHistoryExpected.getId());
        expected.setName(EStatusHistory.CANCELED);
        StatusHistory actual = statusHistoryService.update(expected);

        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        List<StatusHistory> expectedAll = List.of(statusHistoryExpected, statusHistoryTest);
        List<StatusHistory> actualAll = statusHistoryService.getAll();

        assertEquals(expectedAll, actualAll);
    }

    @Test
    void deleteCheckForNotFoundUserAfterDelete() {
        int expectedCount = statusHistoryService.getAll().size() - 1;
        statusHistoryService.delete(statusHistoryExpected);
        int actualCount = statusHistoryService.getAll().size();

        assertThrows(EntityNotFoundException.class,
            () -> statusHistoryService.findById(statusHistoryExpected.getId()));

        assertEquals(expectedCount, actualCount);
    }
}