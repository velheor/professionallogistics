package com.velheor.internship.service;

import static com.velheor.internship.utils.TestUtils.EXPECTED_SIZE;
import static com.velheor.internship.utils.TestUtils.ROLE1;
import static com.velheor.internship.utils.TestUtils.ROLE2;
import static com.velheor.internship.utils.TestUtils.ROLE_IGNORE;
import static com.velheor.internship.utils.TestUtils.USER2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.velheor.internship.BaseTest;
import com.velheor.internship.models.Role;
import com.velheor.internship.models.enums.ERole;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class RoleServiceTest extends BaseTest {

    @Autowired
    private RoleService roleService;

    @Test
    void findById() {
        Role actual = roleService.findById(ROLE1.getId());

        assertThat(actual)
            .isEqualToIgnoringGivenFields(ROLE1, ROLE_IGNORE);
    }

    @Test
    void findByIdThrownEntityNotFoundException() {
        UUID notExistsId = UUID.fromString("74a07384-93b8-11eb-a8b3-0242ac130003");

        assertThatThrownBy(() -> roleService.findById(notExistsId))
            .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void create() {
        Role expected = new Role();
        expected.setName(ERole.ADMIN);
        expected.setUser(USER2);
        Role actual = roleService.save(expected);

        assertThat(actual)
            .isEqualToIgnoringGivenFields(expected, ROLE_IGNORE);
    }

    @Test
    void update() {
        Role expected = new Role(ROLE1);
        expected.setName(ERole.ADMIN);
        Role actual = roleService.save(expected);

        assertThat(actual)
            .isEqualToIgnoringGivenFields(expected, ROLE_IGNORE);
    }

    @Test
    void getAll() {
        List<Role> expectedAll = List.of(ROLE1, ROLE2);
        List<Role> actualAll = new ArrayList<>();
        roleService.getAll().forEach(actualAll::add);

        assertThat(expectedAll).usingElementComparatorIgnoringFields(ROLE_IGNORE)
            .isEqualTo(actualAll);
    }

    @Test
    void deleteById() {
        roleService.deleteById(ROLE1.getId());

        int actualSize = 0;
        for (Object ignored : roleService.getAll()) {
            actualSize++;
        }

        assertThat(actualSize).isEqualTo(EXPECTED_SIZE);

        assertThatThrownBy(() -> roleService.findById(ROLE1.getId()))
            .isInstanceOf(EntityNotFoundException.class);
    }
}
