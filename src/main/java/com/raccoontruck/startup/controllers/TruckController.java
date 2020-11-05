package com.raccoontruck.startup.controllers;

import com.raccoontruck.startup.models.Truck;
import com.raccoontruck.startup.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TruckController {
    private final TruckRepository truckRepository;

    @Autowired
    TruckController(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    @GetMapping("/voenka")
    public List<Truck> findAll() {
        return truckRepository.findAll();
    }
}
