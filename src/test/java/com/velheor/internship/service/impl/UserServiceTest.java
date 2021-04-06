package com.velheor.internship.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.config.H2JpaConfig;
import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.ERole;
import com.velheor.internship.service.api.IUserService;
import java.util.Arrays;
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
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:beforeTest.sql"})
class UserServiceTest {

    @Autowired
    private IUserService userService;

    private User expected;

    private UUID id;

    @BeforeEach
    void setUp() {
        expected = new User();
        id = UUID.fromString("47a07384-93b8-11eb-a8b3-0242ac130003");
        expected.setId(id);
        expected.setFirstName("Ivan");
        expected.setLastName("Ivanov");
        expected.setEmail("ivan@gmail.com");
        expected.setPhoneNumber("+375331234567");
        expected.setPassword("pass1");
        expected.setRole(ERole.CARRIER);
    }

    @Test
    void findByIdReturnsUser() {
        User actual = userService.findById(id);
        assertEquals(expected, actual);
    }

    @Test
    void findByIdThrowsNotFounException() {
        UUID notExistsId = UUID.fromString("74a07384-93b8-11eb-a8b3-0242ac130003");
        assertThrows(EntityNotFoundException.class,
            () -> userService.findById(notExistsId));
    }

    @Test
    void create() {
        User expected = new User();
        expected.setFirstName("NotIvan");
        expected.setLastName("NotIvanov");
        expected.setEmail("notivan@gmail.com");
        expected.setPhoneNumber("+37533111111");
        expected.setPassword("notpass");
        expected.setRole(ERole.CARRIER);
        User actual = userService.create(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        User expected = userService.findById(id);
        expected.setFirstName("Dima");
        expected.setLastName("Bilan");

        User actual = userService.update(expected);

        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        User user2 = new User();
        user2.setId(UUID.fromString("45caf4c2-9565-11eb-a8b3-0242ac130003"));
        user2.setFirstName("Petr");
        user2.setLastName("Petrov");
        user2.setEmail("petr@gmail.com");
        user2.setPhoneNumber("+375296888258");
        user2.setPassword("pass2");
        user2.setRole(ERole.SHIPPER);

        List<User> actual = userService.getAll();
        List<User> expectedGetAll = Arrays
            .asList(expected, user2);

        assertEquals(expectedGetAll, actual);
    }

    @Test
    void deleteCheckForNotFoundUser() {
        userService.delete(expected);
        assertThrows(EntityNotFoundException.class, () -> userService.findById(id));
    }

    @Test
    void deleteCheckForCountAfterDelete() {
        int expectedCount = userService.getAll().size() - 1;
        userService.delete(expected);
        int actualCount = userService.getAll().size();
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void findByEmailReturnsUser() {
        User actual = userService.findByEmail(expected.getEmail());

        assertEquals(expected, actual);
    }

    @Test
    void findByEmailThrowsEntityNotFoundException() {
        String notExistsEmail = "notExistEmail";
        assertThrows(EntityNotFoundException.class,
            () -> userService.findByEmail(notExistsEmail));
    }
}