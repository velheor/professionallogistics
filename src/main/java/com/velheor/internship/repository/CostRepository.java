package com.velheor.internship.repository;

import com.velheor.internship.models.Cost;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CostRepository extends CrudRepository<Cost, UUID> {

    @EntityGraph(value = "OrderWithUsers")
    Iterable<Cost> findAll();
}
