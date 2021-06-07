package com.velheor.internship.repository;

import com.velheor.internship.models.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {

    @EntityGraph(value = "UserWithRoles")
    Iterable<Order> findAll();
}
