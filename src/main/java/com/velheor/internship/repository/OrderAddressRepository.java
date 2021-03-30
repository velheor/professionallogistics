package com.velheor.internship.repository;

import com.velheor.internship.models.OrderAddress;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface OrderAddressRepository extends CrudRepository<OrderAddress, UUID> {

    @Override
    List<OrderAddress> findAll();
}
