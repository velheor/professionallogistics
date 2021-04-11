package com.velheor.internship.service;

import com.velheor.internship.models.Order;
import com.velheor.internship.models.TruckCategory;
import com.velheor.internship.repository.OrderRepository;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order findById(UUID id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "Order with id: " + id.toString() + "was not found."));
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public Order update(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public void delete(Order order) {
        if (order.getTruckCategories() != null) {
            for (TruckCategory truckCategory : order.getTruckCategories()) {
                truckCategory.deleteOrder(order);
            }
        }
        orderRepository.delete(order);
    }
}
