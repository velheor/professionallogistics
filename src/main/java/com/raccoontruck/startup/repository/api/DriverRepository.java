package com.raccoontruck.startup.repository.api;

import com.raccoontruck.startup.models.Driver;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DriverRepository extends CrudRepository<Driver, Long> {
    List<Driver> findAll();
}