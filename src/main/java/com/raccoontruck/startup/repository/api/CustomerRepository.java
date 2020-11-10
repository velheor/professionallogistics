package com.raccoontruck.startup.repository.api;

import com.raccoontruck.startup.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findAll();
}