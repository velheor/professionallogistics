package com.raccoontruck.startup;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DriverRepository extends CrudRepository<Driver, Long> {
    List<Driver> findAll();
}