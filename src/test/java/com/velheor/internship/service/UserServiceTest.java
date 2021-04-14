package com.velheor.internship.service;

import static com.velheor.internship.utils.TestUtils.EXPECTED_SIZE;
import static com.velheor.internship.utils.TestUtils.USER1;
import static com.velheor.internship.utils.TestUtils.USER2;
import static com.velheor.internship.utils.TestUtils.USER_IGNORE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.velheor.internship.BaseTest;
import com.velheor.internship.models.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    void findByIdReturnsUser() {
        User actual = userService.findById(USER1.getId());
        assertThat(actual).isEqualToIgnoringGivenFields(USER1, USER_IGNORE);
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

        assertThat(actual).isEqualToIgnoringGivenFields(expected, USER_IGNORE);
    }

    @Test
    void update() {
        User expected = new User(USER1);
        expected.setFirstName("Dima");
        expected.setLastName("Bilan");

        User actual = userService.save(expected);

        assertThat(actual).isEqualToIgnoringGivenFields(expected, USER_IGNORE);
    }

    @Test
    void getAll() {
        List<User> actualAll = new ArrayList<>();
        userService.getAll().forEach(actualAll::add);
        List<User> expectedAll = Arrays.asList(USER1, USER2);

        assertThat(expectedAll).usingElementComparatorIgnoringFields(USER_IGNORE)
            .isEqualTo(actualAll);

    }

    @Test
    public void deleteById() {
        userService.deleteById(USER1.getId());

        int actualSize = 0;
        for (Object ignored : userService.getAll()) {
            actualSize++;
        }

        assertThat(actualSize).isEqualTo(EXPECTED_SIZE);

        assertThatThrownBy(() -> userService.findById(USER1.getId()))
            .isInstanceOf(EntityNotFoundException.class);

    }

    @Test
    void findByEmailReturnsUser() {
        User actual = userService.findByEmail(USER1.getEmail());

        assertThat(actual).isEqualToIgnoringGivenFields(USER1, USER_IGNORE);
    }

    @Test
    void findByEmailThrowsEntityNotFoundException() {
        String notExistsEmail = "notExistsEmail";

        assertThatThrownBy(() -> userService.findByEmail(notExistsEmail))
            .isInstanceOf(EntityNotFoundException.class);
    }
}