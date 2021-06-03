package com.velheor.internship.controllers;

import com.velheor.internship.dto.TruckViewDto;
import com.velheor.internship.mappers.TruckMapper;
import com.velheor.internship.service.TruckService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/trucks")
@RequiredArgsConstructor
public class TruckController {

    private final TruckService truckService;
    private final TruckMapper truckMapper;

    @GetMapping
    @ApiOperation(value = "Get all trucks")
    public Iterable<TruckViewDto> getAll() {
        return truckMapper.toTrucksDto(truckService.getAll());
    }

    @GetMapping("/{id}")
    public TruckViewDto findById(@PathVariable("id") UUID id) {
        return truckMapper.toTruckViewDto(truckService.findById(id));
    }

    @PutMapping
    public TruckViewDto update(@Valid @RequestBody TruckViewDto truckViewDto) {
        return truckMapper.toTruckViewDto(truckService.save(truckMapper.toTruck(truckViewDto)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TruckViewDto save(@Valid @RequestBody TruckViewDto truckViewDto) {
        return truckMapper
                .toTruckViewDto(truckService.save(truckMapper.toTruck(truckViewDto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") UUID id) {
        truckService.deleteById(id);
    }
}
