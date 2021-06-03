package com.velheor.internship.controllers;

import com.velheor.internship.dto.StatusViewDto;
import com.velheor.internship.mappers.StatusMapper;
import com.velheor.internship.service.StatusService;
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
@RequestMapping("/statuses")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService statusService;
    private final StatusMapper statusMapper;

    @GetMapping("/{id}")
    public StatusViewDto findById(@PathVariable("id") UUID id) {
        return statusMapper.toStatusViewDto(statusService.findById(id));
    }

    @PutMapping
    public StatusViewDto update(@Valid @RequestBody StatusViewDto statusViewDTO) {
        return statusMapper.toStatusViewDto(statusService.save(statusMapper.toStatus(statusViewDTO)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StatusViewDto save(@Valid @RequestBody StatusViewDto statusViewDTO) {
        return statusMapper.toStatusViewDto(statusService.save(statusMapper.toStatus(statusViewDTO)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") UUID id) {
        statusService.deleteById(id);
    }
}
