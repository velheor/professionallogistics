package com.velheor.internship.service;

import com.velheor.internship.dto.OrderFilterDto;
import com.velheor.internship.models.GenericSpecification;
import com.velheor.internship.models.Order;
import com.velheor.internship.models.SearchCriteria;
import com.velheor.internship.models.enums.SearchOperation;
import com.velheor.internship.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

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
        SearchCriteria gtPrice = new SearchCriteria(PRICE, orderFilterDto.getPriceFrom(), SearchOperation.GREATER_THAN);
        SearchCriteria ltPrice = new SearchCriteria(PRICE, orderFilterDto.getPriceTo(), SearchOperation.LESS_THAN);

        SearchCriteria gtDateFrom = new SearchCriteria(PRICE, orderFilterDto.getDateFrom(), SearchOperation.GREATER_THAN);
        SearchCriteria ltDateTo = new SearchCriteria(PRICE, orderFilterDto.getDateTo(), SearchOperation.LESS_THAN);

        Specification<Order> commonSpecPrice = specificationAnd(gtPrice, ltPrice);
        Specification<Order> commonSpecDate = specificationAnd(gtDateFrom, ltDateTo);

        Specification<Order> commonSpec = commonSpecPrice.and(commonSpecDate);

        return orderRepository.findAll(commonSpec);
    }

    private Specification<Order> specificationAnd(SearchCriteria left, SearchCriteria right) {
        return new GenericSpecification<Order>(left).and(new GenericSpecification<>(right));
    }
}
