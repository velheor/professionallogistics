package com.velheor.internship.service.impl;

import static com.velheor.internship.service.impl.TestUtils.EXPECTED_SIZE;
import static com.velheor.internship.service.impl.TestUtils.USER1;
import static com.velheor.internship.service.impl.TestUtils.USER2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.ERole;
import com.velheor.internship.service.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UserServiceTest implements BaseServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void findByIdReturnsUser() {
        User actual = userService.findById(USER1.getId());

        assertEquals(USER1, actual);
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

        User actual = userService.save(expected);

        assertEquals(expected, actual);
    }

    @Test
    void update() {
        User expected = userService.findById(USER1.getId());
        expected.setFirstName("Dima");
        expected.setLastName("Bilan");

        User actual = userService.save(expected);

        assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        List<User> actualAll = new ArrayList<>();
        userService.getAll().forEach(actualAll::add);
        List<User> expectedAll = Arrays
            .asList(USER1, USER2);

        assertEquals(expectedAll, actualAll);
    }

    @Test
    public void deleteById() {
        userService.deleteById(USER1.getId());
        int actualSize = 0;
        for (Object i : userService.getAll()) {
            actualSize++;
        }
        assertEquals(EXPECTED_SIZE, actualSize);

        assertThrows(EntityNotFoundException.class,
            () -> userService.findById(USER1.getId()));

    }

    @Test
    void findByEmailReturnsUser() {
        User actual = userService.findByEmail(USER1.getEmail());

        assertEquals(USER1, actual);
    }

    @Test
    void findByEmailThrowsEntityNotFoundException() {
        String notExistsEmail = "notExistsEmail";

        assertThrows(EntityNotFoundException.class,
            () -> userService.findByEmail(notExistsEmail));
    }
}