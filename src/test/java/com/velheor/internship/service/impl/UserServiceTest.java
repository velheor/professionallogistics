package com.velheor.internship.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.config.H2JpaConfig;
import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.ERole;
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
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:beforeUserTest.sql"})
class UserServiceTest {

    @Autowired
    private UserService userService;

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
        expected.setPassword("pass");
        expected.setRole(ERole.CARRIER);
    }

    @Test
    void findById() {

        User actual = userService.findById(id);

        assertEquals(expected, actual);

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

        User user3 = new User();
        user3.setId(UUID.fromString("4de5a6c0-9565-11eb-a8b3-0242ac130003"));
        user3.setFirstName("Kirill");
        user3.setLastName("Kirillov");
        user3.setEmail("kirill@gmail.com");
        user3.setPhoneNumber("+375291448939");
        user3.setPassword("pass3");
        user3.setRole(ERole.CARRIER);

        List<User> actual = userService.getAll();
        List<User> expectedGetAll = Arrays
            .asList(expected, user2, user3);

        assertEquals(expectedGetAll, actual);
    }

    @Test
    void delete() {
        User expected = userService.findById(id);
        userService.delete(expected);
        assertThrows(EntityNotFoundException.class, () -> userService.findById(expected.getId()));
    }

    @Test
    void findByEmail() {
        User actual = userService.findByEmail(expected.getEmail());

        assertEquals(expected, actual);

        String notExistsEmail = "notExistEmail";
        assertThrows(EntityNotFoundException.class,
            () -> userService.findByEmail(notExistsEmail));
    }
}