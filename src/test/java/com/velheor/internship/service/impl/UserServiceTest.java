package com.velheor.internship.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.velheor.internship.config.H2JpaConfig;
import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.ERole;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(classes = {H2JpaConfig.class})
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:beforeTest.sql"})
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void findById() {
        UUID uuid = UUID.fromString("47a07384-93b8-11eb-a8b3-0242ac130003");
        User expected = new User();
        expected.setId(uuid);
        expected.setFirstName("Ivan");
        expected.setLastName("Ivanov");
        expected.setEmail("ivan@gmail.com");
        expected.setPhoneNumber("+375331234567");
        expected.setPassword("pass");
        expected.setRole(ERole.CARRIER);

        User actual = userService.findById(uuid);

        assertEquals(expected, actual);
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void getAll() {
        userService.getAll().forEach(entity -> System.out.println(entity.getId()));
    }

    @Test
    void delete() {
    }

    @Test
    void findByEmail() {
    }
}