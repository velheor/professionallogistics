package com.velheor.internship.service.impl;

import com.velheor.internship.models.OrderAddress;
import com.velheor.internship.repository.OrderAddressRepository;
import com.velheor.internship.service.api.IOrderAddressService;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderAddressService implements IOrderAddressService {

    private final OrderAddressRepository orderAddressRepository;

    @Override
    public OrderAddress findById(UUID id) {
        return orderAddressRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "OrderAdress with id: " + id.toString() + " was not found."));
    }

    @Override
    public OrderAddress create(OrderAddress orderAddress) {
        return orderAddressRepository.save(orderAddress);
    }

    @Override
    public OrderAddress update(OrderAddress orderAddress) {
        return orderAddressRepository.save(orderAddress);
    }

    @Override
    public List<OrderAddress> getAll() {
        return orderAddressRepository.findAll();
    }

    @Override
    public void delete(OrderAddress orderAddress) {
        orderAddressRepository.delete(orderAddress);
    }
}
