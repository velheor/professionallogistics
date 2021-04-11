package com.velheor.internship.repository;

import com.velheor.internship.models.Truck;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface TruckRepository extends CrudRepository<Truck, UUID> {

}
