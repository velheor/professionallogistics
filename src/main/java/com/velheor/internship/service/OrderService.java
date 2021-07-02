package com.velheor.internship.service;

import com.velheor.internship.dto.OrderFilterDto;
import com.velheor.internship.models.Order;
import com.velheor.internship.repository.OrderRepository;
import com.velheor.internship.service.specification.JpaSpecificationBuilder;
import com.velheor.internship.service.specification.SearchCriteria;
import com.velheor.internship.service.specification.SearchOperation;
import com.velheor.internship.service.specification.SpecificationDiapason;
import com.velheor.internship.service.specification.utils.SpecificationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

import static com.velheor.internship.service.specification.SearchOperation.AND;
import static com.velheor.internship.service.specification.SearchOperation.EQUALS;
import static com.velheor.internship.service.specification.SearchOperation.GREATER_THAN;
import static com.velheor.internship.service.specification.SearchOperation.LESS_THAN;

@Service
@RequiredArgsConstructor
public class OrderService {
    private static final String DATE_FROM = "datePickup";
    private static final String DATE_TO = "dateDelivery";
    private static final String PRICE = "price";
    private final JpaSpecificationBuilder<Order> jpaSpecificationBuilder = new JpaSpecificationBuilder<>();
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

        SpecificationDiapason filterPrice = getPriceDiapason(orderFilterDto);

        Specification<Order> priceSpecification = SpecificationUtil.prepareDiapason(filterPrice);

        SpecificationDiapason filterDate = getDateDiapason(orderFilterDto);

        Specification<Order> dateSpecification = SpecificationUtil.prepareDiapason(filterDate);

        Specification<Order> result = priceSpecification.and(dateSpecification);

        return orderRepository.findAll(result);
    }

    public Iterable<Order> findByNameCarrier(String firstName, String lastName) {

        SearchCriteria searchCriteria1 = SearchCriteria.builder()
                .key("shipper.firstName")
                .value(firstName)
                .operation(EQUALS)
                .build();

        SearchCriteria searchCriteria2 = SearchCriteria.builder()
                .key("shipper.lastName")
                .value(lastName)
                .operation(EQUALS)
                .build();

        SearchCriteria searchCriteriaResult = SearchCriteria.builder()
                .criteria(List.of(searchCriteria1, searchCriteria2))
                .operation(AND)
                .build();

        return orderRepository.findAll(jpaSpecificationBuilder.buildSpecification(searchCriteriaResult));
    }

    private SpecificationDiapason getDateDiapason(OrderFilterDto orderFilterDto) {
        SearchCriteria searchCriteriaLeft = SearchCriteria.builder()
                .key(DATE_FROM)
                .value(orderFilterDto.getDateFrom())
                .operation(GREATER_THAN)
                .build();

        SearchCriteria searchCriteriaRight = SearchCriteria.builder()
                .key(DATE_TO)
                .value(orderFilterDto.getDateTo())
                .operation(LESS_THAN)
                .build();

        return SpecificationDiapason.builder()
                .searchCriteriaLeft(searchCriteriaLeft)
                .searchCriteriaRight(searchCriteriaRight)
                .combine(AND)
                .build();
    }

    private SpecificationDiapason getPriceDiapason(OrderFilterDto orderFilterDto) {
        SearchCriteria searchCriteriaLeft = SearchCriteria.builder()
                .key(PRICE)
                .value(orderFilterDto.getPriceFrom())
                .operation(GREATER_THAN)
                .build();

        SearchCriteria searchCriteriaRight = SearchCriteria.builder()
                .key(PRICE)
                .value(orderFilterDto.getDateTo())
                .operation(LESS_THAN)
                .build();

        return SpecificationDiapason.builder()
                .searchCriteriaLeft(searchCriteriaLeft)
                .searchCriteriaRight(searchCriteriaRight)
                .combine(AND)
                .build();
    }
}
