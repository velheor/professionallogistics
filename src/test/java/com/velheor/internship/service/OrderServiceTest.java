package com.velheor.internship.service;

import static com.velheor.internship.utils.TestUtils.EXPECTED_SIZE;
import static com.velheor.internship.utils.TestUtils.ORDER1;
import static com.velheor.internship.utils.TestUtils.ORDER2;
import static com.velheor.internship.utils.TestUtils.ORDER_IGNORE;
import static com.velheor.internship.utils.TestUtils.USER2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.velheor.internship.BasePersistenceTest;
import com.velheor.internship.models.Order;
import com.velheor.internship.models.enums.ETruckCategory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class OrderServiceTest extends BasePersistenceTest {

    @Autowired
    private OrderService orderService;

    @Test
    void findById() {
        Order actual = orderService.findById(ORDER1.getId());

        assertThat(actual).isEqualToIgnoringGivenFields(ORDER1, ORDER_IGNORE);
    }

    @Test
    void findByIdThrownEntityNotFoundException() {
        UUID notExistsId = UUID.fromString("74a07384-93b8-11eb-a8b3-0242ac130003");

        assertThatThrownBy(() -> orderService.findById(notExistsId))
            .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void create() {
        Order expected = new Order();
        expected.setDateDelivery(LocalDateTime.of(2021, 1, 10, 12, 0));
        expected.setDatePickup(LocalDateTime.of(2021, 1, 12, 6, 0));
        expected.setPrice(new BigDecimal("300"));
        expected.setTruckCategory(ETruckCategory.ALL_METAL);
        expected.setShipper(USER2);
        Order actual = orderService.save(expected);

        assertThat(actual).isEqualToIgnoringGivenFields(expected, ORDER_IGNORE);
    }

    @Test
    void update() {
        Order expected = new Order(ORDER1);
        expected.setTruckCategory(ETruckCategory.COVERED);
        Order actual = orderService.save(expected);

        assertThat(actual).isEqualToIgnoringGivenFields(expected, ORDER_IGNORE);
    }

    @Test
    void getAll() {
        List<Order> expectedAll = List.of(ORDER1, ORDER2);
        List<Order> actualAll = new ArrayList<>();
        orderService.getAll().forEach(actualAll::add);

        assertThat(expectedAll).usingElementComparatorIgnoringFields(ORDER_IGNORE)
            .isEqualTo(actualAll);

    }

    @Test
    void deleteById() {
        orderService.deleteById(ORDER1.getId());

        int actualSize = 0;
        for (Object ignored : orderService.getAll()) {
            actualSize++;
        }

        assertThat(actualSize).isEqualTo(EXPECTED_SIZE);

        assertThatThrownBy(() -> orderService.findById(ORDER1.getId()))
            .isInstanceOf(EntityNotFoundException.class);
    }
}