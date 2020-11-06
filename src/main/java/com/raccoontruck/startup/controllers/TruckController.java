package com.raccoontruck.startup.controllers;

import com.raccoontruck.startup.dto.TruckDTO;
import com.raccoontruck.startup.service.api.ITruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TruckController {
    private final ITruckService truckService;

    @Autowired
    TruckController(ITruckService truckService) {
        this.truckService = truckService;
    }

    @GetMapping("/voenka")
    public List<TruckDTO> findAll() {
        return truckService.findAll();
    }
}
