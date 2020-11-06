package com.raccoontruck.startup.repository.api;

import com.raccoontruck.startup.models.Truck;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TruckRepository extends CrudRepository<Truck, Long> {
    List<Truck> findAll();
}