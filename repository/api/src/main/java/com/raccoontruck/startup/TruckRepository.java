package com.raccoontruck.startup;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TruckRepository extends CrudRepository<Truck, Long> {
    List<Truck> findAll();
}