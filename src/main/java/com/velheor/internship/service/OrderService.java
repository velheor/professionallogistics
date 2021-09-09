package com.velheor.internship.service;

import com.velheor.internship.dto.OrderFilterDto;
import com.velheor.internship.models.Order;
import com.velheor.internship.models.User;
import com.velheor.internship.repository.OrderRepository;
import com.velheor.internship.service.specification.JpaSpecificationBuilder;
import com.velheor.internship.service.specification.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

import static com.velheor.internship.service.specification.JoinType.AND;
import static com.velheor.internship.service.specification.SearchOperation.GREATER_THAN;
import static com.velheor.internship.service.specification.SearchOperation.LESS_THAN;

@Service
@RequiredArgsConstructor
public class OrderService {

    private static final String DATE_FROM = "datePickup";
    private static final String DATE_TO = "dateDelivery";
    private static final String PRICE = "price";
    private final JpaSpecificationBuilder<Order> jpaSpecificationBuilder;
    private final OrderRepository orderRepository;

    public Order findById(UUID id) {
        return orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Order with id: " + id + "was not found."));
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Iterable<Order> getAll() {
        return orderRepository.findAll();
    }

    public void deleteById(UUID id) {
        orderRepository.deleteById(id);
    }

    public void saveAll(Iterable<Order> orders) {
        orderRepository.saveAll(orders);
    }

    public Iterable<Order> filterOrders(OrderFilterDto orderFilterDto) {
        SearchCriteria criterionGreaterDate = getCriterionGreaterDate(orderFilterDto);
        SearchCriteria criterionLessDate = getCriterionLessDate(orderFilterDto);
        SearchCriteria criterionGreaterPrice = getCriterionGreaterPrice(orderFilterDto);
        SearchCriteria criterionLessPrice = getCriterionLessPrice(orderFilterDto);
        SearchCriteria result = buildFilter(List.of(criterionGreaterDate, criterionLessDate, criterionGreaterPrice, criterionLessPrice));

        return orderRepository.findAll(jpaSpecificationBuilder.buildSpecification(result));
    }

    private SearchCriteria buildFilter(List<SearchCriteria> criteria) {
        return SearchCriteria.builder()
                .criteria(criteria)
                .joinType(AND)
                .build();
    }

    private SearchCriteria getCriterionGreaterDate(OrderFilterDto orderFilterDto) {
        return SearchCriteria.builder()
                .key(DATE_FROM)
                .value(orderFilterDto.getDateFrom())
                .operation(GREATER_THAN)
                .build();
    }

    private SearchCriteria getCriterionLessDate(OrderFilterDto orderFilterDto) {
        return SearchCriteria.builder()
                .key(DATE_TO)
                .value(orderFilterDto.getDateTo())
                .operation(LESS_THAN)
                .build();
    }

    private SearchCriteria getCriterionGreaterPrice(OrderFilterDto orderFilterDto) {
        return SearchCriteria.builder()
                .key(PRICE)
                .value(orderFilterDto.getPriceFrom())
                .operation(GREATER_THAN)
                .build();
    }

    private SearchCriteria getCriterionLessPrice(OrderFilterDto orderFilterDto) {
        return SearchCriteria.builder()
                .key(PRICE)
                .value(orderFilterDto.getPriceTo())
                .operation(LESS_THAN)
                .build();
    }

    public Order getRandomOrder() {
        long qty = orderRepository.count();
        int idx = (int) (Math.random() * qty);
        Page<Order> orderPage = orderRepository.findAll(PageRequest.of(idx, 1));
        return orderPage.getContent().get(0);
    }
}
