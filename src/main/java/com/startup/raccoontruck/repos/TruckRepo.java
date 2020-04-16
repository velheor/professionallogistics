package com.startup.raccoontruck.repos;

import com.startup.raccoontruck.domain.Truck;

import java.util.List;

public interface TruckRepo {
    List<Truck> findByUser(String userName);
}
