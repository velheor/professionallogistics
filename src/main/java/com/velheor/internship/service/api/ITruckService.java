package com.velheor.internship.service.api;

import com.velheor.internship.models.Truck;
import java.util.UUID;

public interface ITruckService extends Crud<Truck> {

    Truck findById(UUID id);
}
