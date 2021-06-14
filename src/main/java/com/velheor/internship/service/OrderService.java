package com.velheor.internship.service;

import com.velheor.internship.dto.OrderFilterDto;
import com.velheor.internship.models.Order;
import com.velheor.internship.repository.OrderRepository;
import com.velheor.internship.service.specification.SpecificationDiapason;
import com.velheor.internship.service.specification.utils.SpecificationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    public Iterable<Order> findByNameCarrier(String name) {
        SpecificationDiapason specDiapason =  SpecificationDiapason.builder()
                .left(name)
                .keyLeft("shipper.firstName")
                .operationLeft(EQUALS)
                .build();

        SpecificationDiapason specDiapasonTest =  SpecificationDiapason.builder()
                .left(name)
                .keyLeft("shipper.lastName")
                .operationLeft(EQUALS)
                .build();

        Specification<Order> specificationTest = SpecificationUtil.prepareDiapason(specDiapasonTest);

        Specification<Order> specification = SpecificationUtil.prepareDiapason(specDiapason);

        Specification<Order> result = specification.and(specificationTest);

        return orderRepository.findAll(result);
    }

    private SpecificationDiapason getDateDiapason(OrderFilterDto orderFilterDto) {
        return SpecificationDiapason.builder()
                .left(orderFilterDto.getDateFrom())
                .right(orderFilterDto.getDateTo())
                .keyLeft(DATE_FROM)
                .keyRight(DATE_TO)
                .operationLeft(GREATER_THAN)
                .operationRight(LESS_THAN)
                .combine(AND)
                .build();
    }

    private SpecificationDiapason getPriceDiapason(OrderFilterDto orderFilterDto) {
        return SpecificationDiapason.builder()
                .left(orderFilterDto.getPriceFrom())
                .right(orderFilterDto.getPriceTo())
                .keyLeft(PRICE)
                .keyRight(PRICE)
                .operationLeft(GREATER_THAN)
                .operationRight(LESS_THAN)
                .combine(AND)
                .build();
    }
}
