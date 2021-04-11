package com.velheor.internship.service;

import com.velheor.internship.models.OrderAddress;
import com.velheor.internship.repository.OrderAddressRepository;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderAddressService {

    private final OrderAddressRepository orderAddressRepository;

    public OrderAddress findById(UUID id) {
        return orderAddressRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "OrderAdress with id: " + id.toString() + " was not found."));
    }

    public OrderAddress create(OrderAddress orderAddress) {
        return orderAddressRepository.save(orderAddress);
    }

    public OrderAddress update(OrderAddress orderAddress) {
        return orderAddressRepository.save(orderAddress);
    }

    public List<OrderAddress> getAll() {
        return orderAddressRepository.findAll();
    }

    public void delete(OrderAddress orderAddress) {
        orderAddressRepository.delete(orderAddress);
    }
}
