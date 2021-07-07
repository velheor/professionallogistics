package com.velheor.internship.service;

import com.velheor.internship.BasePersistenceTest;
import com.velheor.internship.models.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static com.velheor.internship.utils.TestUtils.ADDRESS1;
import static com.velheor.internship.utils.TestUtils.ADDRESS2;
import static com.velheor.internship.utils.TestUtils.ADDRESS_IGNORE;
import static com.velheor.internship.utils.TestUtils.EXPECTED_SINGLE;
import static com.velheor.internship.utils.TestUtils.countIterableSize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AddressServiceTest extends BasePersistenceTest {

    @Autowired
    private AddressService addressService;

    @Test
    void findByIdReturnsAddress() {
        Address actual = addressService.findById(ADDRESS1.getId());
        assertThat(actual).isEqualToIgnoringGivenFields(ADDRESS1, ADDRESS_IGNORE);
    }

    @Test
    void findByIdThrowsNotFoundException() {
        UUID notExistsId = UUID.fromString("74a07384-93b8-11eb-a8b3-0242ac130003");
        assertThatThrownBy(() -> addressService.findById(notExistsId))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void create() {
        Address expected = new Address();
        expected.setCountry("Test");
        expected.setCity("Test");
        expected.setStreetName("Test");
        expected.setStreetNumber("1234-B");
        Address actual = addressService.save(expected);

        assertThat(actual).isEqualToIgnoringGivenFields(expected, ADDRESS_IGNORE);
    }

    @Test
    void update() {
        Address expected = new Address(ADDRESS1);

        Address actual = addressService.save(expected);

        assertThat(actual).isEqualToIgnoringGivenFields(expected, ADDRESS_IGNORE);
    }

    @Test
    void getAll() {
        List<Address> actualAll = new ArrayList<>();
        addressService.getAll().forEach(actualAll::add);
        List<Address> expectedAll = Arrays.asList(ADDRESS1, ADDRESS2);

        assertThat(expectedAll).usingElementComparatorIgnoringFields(ADDRESS_IGNORE)
                .isEqualTo(actualAll);

    }

    @Test
    public void deleteById() {
        addressService.deleteById(ADDRESS1.getId());

        int actualSize = countIterableSize(addressService.getAll());

        assertThat(actualSize).isEqualTo(EXPECTED_SINGLE);

        assertThatThrownBy(() -> addressService.findById(ADDRESS1.getId()))
                .isInstanceOf(EntityNotFoundException.class);
    }
}
