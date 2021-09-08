package com.velheor.internship.service;

import com.velheor.internship.BasePersistenceTest;
import com.velheor.internship.dto.OrderFilterDto;
import com.velheor.internship.models.Order;
import com.velheor.internship.models.enums.ETruckCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.velheor.internship.utils.TestUtils.EXPECTED_ALL;
import static com.velheor.internship.utils.TestUtils.EXPECTED_SINGLE;
import static com.velheor.internship.utils.TestUtils.ORDER1;
import static com.velheor.internship.utils.TestUtils.ORDER2;
import static com.velheor.internship.utils.TestUtils.ORDER_IGNORE;
import static com.velheor.internship.utils.TestUtils.USER2;
import static com.velheor.internship.utils.TestUtils.countIterableSize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        //expected.setPrice(new BigDecimal("300"));
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

        int actualSize = countIterableSize(orderService.getAll());

        assertThat(actualSize).isEqualTo(EXPECTED_SINGLE);

        assertThatThrownBy(() -> orderService.findById(ORDER1.getId()))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void filterOrders() {
        int actualSize;
        OrderFilterDto orderFilterDto = new OrderFilterDto();
        orderFilterDto.setPriceFrom(BigDecimal.valueOf(4500));
        Iterable<Order> orders = orderService.filterOrders(orderFilterDto);
        actualSize = countIterableSize(orders);
        assertThat(actualSize).isEqualTo(EXPECTED_SINGLE);

        orders = orderService.filterOrders(new OrderFilterDto());
        actualSize = countIterableSize(orders);
        assertThat(actualSize).isEqualTo(EXPECTED_ALL);
    }
}