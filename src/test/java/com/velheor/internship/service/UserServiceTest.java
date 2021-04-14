package com.velheor.internship.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.velheor.internship.models.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UserServiceTest extends BaseServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void findByIdReturnsUser() {
        User actual = userService.findById(TestUtils.USER1.getId());
        assertThat(actual)
            .isEqualToIgnoringGivenFields(TestUtils.USER1, TestUtils.USER_IGNORE);
    }

    @Test
    void findByIdThrowsNotFoundException() {
        UUID notExistsId = UUID.fromString("74a07384-93b8-11eb-a8b3-0242ac130003");
        assertThatThrownBy(() -> userService.findById(notExistsId))
            .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void create() {
        User expected = new User();
        expected.setFirstName("NotIvan");
        expected.setLastName("NotIvanov");
        expected.setEmail("notivan@gmail.com");
        expected.setPhoneNumber("+37533111111");
        expected.setPassword("notpass");

        User actual = userService.save(expected);

        assertThat(actual)
            .isEqualToIgnoringGivenFields(expected, TestUtils.USER_IGNORE);
    }

    @Test
    void update() {
        User expected = new User(TestUtils.USER1);
        expected.setFirstName("Dima");
        expected.setLastName("Bilan");

        User actual = userService.save(expected);

        assertThat(actual)
            .isEqualToIgnoringGivenFields(expected, TestUtils.USER_IGNORE);
    }

    @Test
    void getAll() {
        List<User> actualAll = new ArrayList<>();
        userService.getAll().forEach(actualAll::add);
        List<User> expectedAll = Arrays
            .asList(TestUtils.USER1, TestUtils.USER2);

        assertThat(expectedAll).usingElementComparatorIgnoringFields(TestUtils.USER_IGNORE)
            .isEqualTo(actualAll);

    }

    @Test
    public void deleteById() {
        userService.deleteById(TestUtils.USER1.getId());

        int actualSize = 0;
        for (Object ignored : userService.getAll()) {
            actualSize++;
        }

        assertThat(actualSize).isEqualTo(TestUtils.EXPECTED_SIZE);

        assertThatThrownBy(() -> userService.findById(TestUtils.USER1.getId()))
            .isInstanceOf(EntityNotFoundException.class);

    }

    @Test
    void findByEmailReturnsUser() {
        User actual = userService.findByEmail(TestUtils.USER1.getEmail());

        assertThat(actual)
            .isEqualToIgnoringGivenFields(TestUtils.USER1, TestUtils.USER_IGNORE);
    }

    @Test
    void findByEmailThrowsEntityNotFoundException() {
        String notExistsEmail = "notExistsEmail";

        assertThatThrownBy(() -> userService.findByEmail(notExistsEmail))
            .isInstanceOf(EntityNotFoundException.class);
    }
}