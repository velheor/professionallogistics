package com.velheor.internship.controllers;

import com.velheor.internship.dto.LoadDTO;
import com.velheor.internship.mappers.LoadMapper;
import com.velheor.internship.service.LoadService;
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
@RequestMapping("/loads")
public class LoadController {

    private final LoadService loadService;
    private final LoadMapper loadMapper;

    @Autowired
    public LoadController(LoadService LoadService, LoadMapper LoadMapper) {
        this.loadService = LoadService;
        this.loadMapper = LoadMapper;
    }

    @GetMapping("/{id}")
    public LoadDTO findById(@PathVariable("id") UUID id) {
        return loadMapper.loadToLoadDto(loadService.findById(id));
    }

    @PutMapping
    public LoadDTO update(@RequestBody LoadDTO LoadDTO) {
        loadService.save(loadMapper.loadDtoToLoad(LoadDTO));
        return LoadDTO;
    }

    @PostMapping
    public LoadDTO save(@RequestBody LoadDTO LoadDTO) {
        loadService.save(loadMapper.loadDtoToLoad(LoadDTO));
        return LoadDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        loadService.deleteById(id);
    }
}
