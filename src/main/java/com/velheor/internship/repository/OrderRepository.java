package com.velheor.internship.repository;

import com.velheor.internship.models.Order;
import com.velheor.internship.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID>, JpaSpecificationExecutor<Order> {

    @EntityGraph(value = "OrderWithUsers")
    Iterable<Order> findAll();

    @EntityGraph(value = "OrderWithUsers")
    List<Order> findAll(Specification<Order> genericSpecification);

    Page<Order> findAll(Pageable pageable);
}
