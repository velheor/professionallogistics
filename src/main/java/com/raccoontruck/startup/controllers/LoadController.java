package com.raccoontruck.startup.controllers;

import com.raccoontruck.startup.models.Load;
import com.raccoontruck.startup.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoadController {
    private final LoadRepository loadRepository;

    @Autowired
    LoadController(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    @GetMapping("/loads")
    public List<Load> findAll() {
        return loadRepository.findAll();
    }
}
