package com.velheor.internship.repository;

import com.velheor.internship.models.Truck;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TruckRepository extends CrudRepository<Truck, UUID> {

}
