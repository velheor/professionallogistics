package com.velheor.internship.service.impl;

import com.velheor.internship.models.Order;
import com.velheor.internship.repository.OrderRepository;
import com.velheor.internship.service.api.IOrderService;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order findById(UUID id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }
}
