package com.velheor.internship.controllers;

import com.velheor.internship.dto.LoadViewDTO;
import com.velheor.internship.mappers.LoadMapper;
import com.velheor.internship.service.LoadService;
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
@RequestMapping("/loads")
@RequiredArgsConstructor
public class LoadController {

    private final LoadService loadService;
    private final LoadMapper loadMapper;

    @GetMapping("/{id}")
    public LoadViewDTO findById(@PathVariable("id") UUID id) {
        return loadMapper.loadToLoadDto(loadService.findById(id));
    }

    @PutMapping
    public LoadViewDTO update(@Valid @RequestBody LoadViewDTO LoadViewDTO) {
        return loadMapper.loadToLoadDto(loadService.save(loadMapper.loadDtoToLoad(LoadViewDTO)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoadViewDTO save(@Valid @RequestBody LoadViewDTO LoadViewDTO) {
        return loadMapper.loadToLoadDto(loadService.save(loadMapper.loadDtoToLoad(LoadViewDTO)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") UUID id) {
        loadService.deleteById(id);
    }
}
