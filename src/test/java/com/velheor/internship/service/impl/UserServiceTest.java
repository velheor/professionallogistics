package com.velheor.internship.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.config.H2JpaConfig;
import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.ERole;
import com.velheor.internship.service.api.IOrderService;
import com.velheor.internship.service.api.IUserService;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {H2JpaConfig.class})
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:beforeTest.sql"})
class UserServiceTest extends BaseTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private IOrderService orderService;

    @Test
    void findByIdReturnsUser() {
        User actual = userService.findById(userExpected.getId());

        assertEquals(userExpected, actual);
    }

    @Test
    void findByIdThrowsNotFoundException() {
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
        User expected = userService.findById(userExpected.getId());
        expected.setFirstName("Dima");
        expected.setLastName("Bilan");

        User actual = userService.update(expected);

        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        List<User> actualAll = userService.getAll();
        List<User> expectedAll = Arrays
            .asList(userExpected, userExistsInDB);

        assertEquals(expectedAll, actualAll);
    }

    @Test
    public void delete() {
        int expectedCount = userService.getAll().size() - 1;
        userService.delete(userExpected);
        int actualCount = userService.getAll().size();

        assertThrows(EntityNotFoundException.class,
            () -> userService.findById(userExpected.getId()));

        assertEquals(expectedCount, actualCount);
    }

    @Test
    void findByEmailReturnsUser() {
        User actual = userService.findByEmail(userExpected.getEmail());

        assertEquals(userExpected, actual);
    }

    @Test
    void findByEmailThrowsEntityNotFoundException() {
        String notExistsEmail = "notExistsEmail";

        assertThrows(EntityNotFoundException.class,
            () -> userService.findByEmail(notExistsEmail));
    }

    @Test
    @Transactional
    public void checkForCorrectDeleteInManyToMany() {
        userService.delete(userService.findById(userExpected.getId()));
        assertThrows(EntityNotFoundException.class,
            () -> userService.findById(userExpected.getId()));
        assertEquals(orderExpected, orderService.findById(orderExpected.getId()));
    }
}