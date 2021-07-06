package com.velheor.internship.service;

import com.velheor.internship.BasePersistenceTest;
import com.velheor.internship.exception.JwtAuthenticationException;
import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.ERole;
import com.velheor.internship.models.enums.EUserStatus;
import com.velheor.internship.security.JwtProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static com.velheor.internship.utils.TestUtils.EXPECTED_SIZE;
import static com.velheor.internship.utils.TestUtils.USER1;
import static com.velheor.internship.utils.TestUtils.USER2;
import static com.velheor.internship.utils.TestUtils.USER_DOES_NOT_EXIST_IN_DB;
import static com.velheor.internship.utils.TestUtils.USER_IGNORE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserServiceTest extends BasePersistenceTest {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserService userService;

    @Test
    void findById() {
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
        User actual = userService.save(USER_DOES_NOT_EXIST_IN_DB);

        assertThat(actual).isEqualToIgnoringGivenFields(USER_DOES_NOT_EXIST_IN_DB, USER_IGNORE);
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

    @Test
    void updateCurrentUser() {
        User expected = new User(USER1);
        expected.setEmail("test@gmail.com");
        expected.setFirstName("test");
        expected.setStatus(EUserStatus.INACTIVE);

        User actual = userService.updateCurrentUser(USER1.getEmail(), expected);
        String[] userIgnoreWithPassword = Arrays.copyOf(USER_IGNORE, USER_IGNORE.length + 1);
        userIgnoreWithPassword[USER_IGNORE.length] = "password";
        assertThat(actual).isEqualToIgnoringGivenFields(expected, userIgnoreWithPassword);
    }

    @Test
    void registerUser() {
        User expected = new User(USER_DOES_NOT_EXIST_IN_DB);
        User actual = userService.registerUser(USER_DOES_NOT_EXIST_IN_DB);
        String[] userIgnoreWithPassword = Arrays.copyOf(USER_IGNORE, USER_IGNORE.length + 1);
        userIgnoreWithPassword[USER_IGNORE.length] = "password";
        assertThat(actual).isEqualToIgnoringGivenFields(expected, userIgnoreWithPassword);
    }

    @Test
    void changeAccountStatusByEmail() {
        userService.changeAccountStatusByEmail(EUserStatus.BANNED, USER1.getEmail());
        assertThat(EUserStatus.BANNED).isEqualTo(userService.findByEmail(USER1.getEmail()).getStatus());
    }

    @Test
    void createWebToken() {
        String jwt = userService.createWebToken(USER1.getEmail(), Collections.singletonList(ERole.CARRIER.name()));
        assertTrue(jwtProvider.validateToken(jwt));
    }

    @Test
    void validateTokenTrowException() {
        String errorJwt = "test";
        assertThatThrownBy(() -> userService.validateToken(errorJwt))
                .isInstanceOf(JwtAuthenticationException.class);
    }

    @Test
    void getEmailFromToken() {
        String expected = USER1.getEmail();
        String jwt = userService.createWebToken(USER1.getEmail(), Collections.singletonList(ERole.CARRIER.name()));
        String actual = userService.getEmailFromToken(jwt);
        assertThat(actual).isEqualTo(expected);
    }
}