package com.velheor.internship.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.config.H2JpaConfig;
import com.velheor.internship.models.StatusHistory;
import com.velheor.internship.models.enums.EStatusHistory;
import com.velheor.internship.service.api.IOrderService;
import com.velheor.internship.service.api.IStatusHistoryService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
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
class StatusHistoryServiceTest {

    @Autowired
    private IStatusHistoryService statusHistoryService;

    @Autowired
    private IOrderService orderService;

    private StatusHistory expected;

    private UUID id;

    @BeforeEach
    void setUp() {
        expected = new StatusHistory();
        id = UUID.fromString("377514cc-958b-11eb-a8b3-0242ac130003");
        expected.setId(id);
        expected.setName(EStatusHistory.STARTED);
        expected.setStatusDate(LocalDateTime.of(2020, 1, 4, 11, 30));
        expected.setOrder(
            orderService.findById(UUID.fromString("377514cc-958b-11eb-a8b3-0242ac130003")));
    }

    @Test
    void findByIdReturnsStatusHistory() {
        StatusHistory actual = statusHistoryService.findById(id);
        assertEquals(expected, actual);
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
        expected.setOrder(
            orderService.findById(UUID.fromString("3a424170-958b-11eb-a8b3-0242ac130003")));

        StatusHistory actual = statusHistoryService.create(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        expected.setName(EStatusHistory.CANCELED);
        StatusHistory actual = statusHistoryService.update(expected);
        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        StatusHistory statusHistory = new StatusHistory();
        statusHistory.setId(UUID.fromString("811f7588-96d8-11eb-a8b3-0242ac130003"));
        statusHistory.setName(EStatusHistory.ENDED);
        statusHistory.setStatusDate(LocalDateTime.of(2021, 1, 4, 11, 30));
        statusHistory.setOrder(
            orderService.findById(UUID.fromString("3a424170-958b-11eb-a8b3-0242ac130003")));

        List<StatusHistory> expectedAll = List.of(expected, statusHistory);
        List<StatusHistory> actualAll = statusHistoryService.getAll();

        assertEquals(expectedAll, actualAll);
    }

    @Test
    void deleteCheckForNotFoundUserAfterDelete() {
        statusHistoryService.delete(expected);
        assertThrows(EntityNotFoundException.class, () -> statusHistoryService.findById(id));
    }

    @Test
    void deleteCheckForCountAfterDelete() {
        int expectedCount = statusHistoryService.getAll().size() - 1;
        statusHistoryService.delete(expected);
        int actualCount = statusHistoryService.getAll().size();
        assertEquals(expectedCount, actualCount);
    }
}