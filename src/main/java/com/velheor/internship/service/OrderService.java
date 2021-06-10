package com.velheor.internship.service;

import com.velheor.internship.dto.OrderFilterDto;
import com.velheor.internship.models.GenericSpecification;
import com.velheor.internship.models.Order;
import com.velheor.internship.models.SearchCriteria;
import com.velheor.internship.models.SpecificationFilter;
import com.velheor.internship.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

import static com.velheor.internship.models.enums.SearchOperation.AND;
import static com.velheor.internship.models.enums.SearchOperation.GREATER_THAN;
import static com.velheor.internship.models.enums.SearchOperation.LESS_THAN;
import static com.velheor.internship.models.enums.SearchOperation.OR;

@Service
@RequiredArgsConstructor
public class OrderService {
    private static final String DATE_FROM = "datePickup";
    private static final String DATE_TO = "dateDelivery";
    private static final String PRICE = "price";

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

        SpecificationFilter filterPrice = SpecificationFilter.builder()
                .left(orderFilterDto.getPriceFrom())
                .right(orderFilterDto.getPriceTo())
                .fieldNameLeft(PRICE)
                .fieldNameRight(PRICE)
                .operationLeft(GREATER_THAN)
                .operationRight(LESS_THAN)
                .combine(AND)
                .cls(Order.class)
                .build();

        Specification<Order> priceSpecification = prepareSpecification(filterPrice);

        SpecificationFilter filterDate = SpecificationFilter.builder()
                .left(orderFilterDto.getPriceFrom())
                .right(orderFilterDto.getPriceTo())
                .operationLeft(GREATER_THAN)
                .operationRight(LESS_THAN)
                .fieldNameLeft(DATE_FROM)
                .fieldNameRight(DATE_TO)
                .combine(AND)
                .cls(Order.class)
                .build();

        Specification<Order> dateSpecification = prepareSpecification(filterDate);

        Specification<Order> result = priceSpecification.and(dateSpecification);

        return orderRepository.findAll(result);
    }

    private Specification<Order> prepareSpecification(SpecificationFilter specificationFilter) {
        Specification<Order> specification = null;

        if (specificationFilter.getLeft() != null) {
            SearchCriteria searchCriteria = new SearchCriteria(specificationFilter.getFieldNameLeft(),
                    specificationFilter.getLeft(), specificationFilter.getOperationLeft());

            specification = new GenericSpecification<>(searchCriteria);
        }

        if (specificationFilter.getRight() != null) {
            SearchCriteria searchCriteria = new SearchCriteria(specificationFilter.getFieldNameLeft(),
                    specificationFilter.getRight(), specificationFilter.getOperationRight());
            GenericSpecification<Order> priceSpecification = new GenericSpecification<>(searchCriteria);

            if (specification == null) {
                specification = priceSpecification;
            } else {
                if (specificationFilter.getCombine().equals(OR)) {
                    specification = specification.or(priceSpecification);
                } else {
                    specification = specification.and(priceSpecification);
                }
            }
        }
        return specification;
    }
}
