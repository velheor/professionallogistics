package com.velheor.internship.controllers;

import com.velheor.internship.dto.StatusDTO;
import com.velheor.internship.mappers.StatusMapper;
import com.velheor.internship.service.StatusService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/status")
public class StatusController {

    private final StatusService statusService;
    private final StatusMapper statusMapper;

    @Autowired
    public StatusController(StatusService statusService, StatusMapper statusMapper) {
        this.statusService = statusService;
        this.statusMapper = statusMapper;
    }

    @GetMapping("/{id}")
    public StatusDTO findById(@PathVariable("id") UUID id) {
        return statusMapper.statusToStatusDto(statusService.findById(id));
    }

    @PutMapping
    public StatusDTO update(@RequestBody StatusDTO statusDTO) {
        statusService.save(statusMapper.statusDtoToStatus(statusDTO));
        return statusDTO;
    }

    @PostMapping
    public StatusDTO save(@RequestBody StatusDTO statusDTO) {
        statusService.save(statusMapper.statusDtoToStatus(statusDTO));
        return statusDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        statusService.deleteById(id);
    }
}
