package com.raccoontruck.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoadController {
    private final ILoadService loadService;

    @Autowired
    LoadController(ILoadService loadService) {
        this.loadService = loadService;
    }

    @GetMapping("/loads")
    public List<LoadDTO> findAll() {
        return loadService.findAll();
    }
}