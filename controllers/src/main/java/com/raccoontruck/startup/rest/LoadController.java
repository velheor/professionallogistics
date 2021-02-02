package com.raccoontruck.startup.rest;

import com.raccoontruck.startup.ILoadService;
import com.raccoontruck.startup.LoadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/load")
public class LoadController {
    private final ILoadService loadService;

    @Autowired
    LoadController(ILoadService LoadService) {
        this.loadService = LoadService;
    }

    @GetMapping
    public List<LoadDTO> getAll() {
        return loadService.findAll();
    }

    @GetMapping("/{id}")
    public LoadDTO getById(@PathVariable("id") Long id) {
        return loadService.findById(id);
    }

    @DeleteMapping
    public LoadDTO delete(@RequestBody LoadDTO loadDTO) {
        loadService.delete(loadDTO.getId());
        return loadDTO;
    }

    @PutMapping
    public LoadDTO update(@RequestBody LoadDTO loadDTO) {
        return loadService.update(loadDTO);
    }

    @PostMapping
    public LoadDTO save(@RequestBody LoadDTO loadDTO) {
        return loadService.update(loadDTO);
    }
}