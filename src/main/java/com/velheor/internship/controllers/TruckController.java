package com.velheor.internship.controllers;

import com.velheor.internship.dto.TruckDTO;
import com.velheor.internship.mappers.TruckMapper;
import com.velheor.internship.service.TruckService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trucks")
@RequiredArgsConstructor
public class TruckController {

    private final TruckService truckService;
    private final TruckMapper truckMapper;

    @GetMapping("/{id}")
    public TruckDTO findById(@PathVariable("id") UUID id) {
        return truckMapper.truckToTruckDto(truckService.findById(id));
    }

    @PutMapping
    public TruckDTO update(@RequestBody TruckDTO truckDto) {
        truckService.save(truckMapper.truckDtoToTruck(truckDto));
        return truckDto;
    }

    @PostMapping
    public TruckDTO save(@RequestBody TruckDTO truckDto) {
        truckService.save(truckMapper.truckDtoToTruck(truckDto));
        return truckDto;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        truckService.deleteById(id);
    }
}
