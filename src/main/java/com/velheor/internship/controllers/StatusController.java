package com.velheor.internship.controllers;

import com.velheor.internship.dto.StatusViewDTO;
import com.velheor.internship.mappers.StatusMapper;
import com.velheor.internship.service.StatusService;
import java.util.UUID;
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

@RestController
@RequestMapping("/statuses")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService statusService;
    private final StatusMapper statusMapper;

    @GetMapping("/{id}")
    public StatusViewDTO findById(@PathVariable("id") UUID id) {
        return statusMapper.statusToStatusDto(statusService.findById(id));
    }

    @PutMapping
    public StatusViewDTO update(@RequestBody StatusViewDTO statusViewDTO) {
        return statusMapper
            .statusToStatusDto(statusService.save(statusMapper.statusDtoToStatus(statusViewDTO)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StatusViewDTO save(@RequestBody StatusViewDTO statusViewDTO) {
        return statusMapper
            .statusToStatusDto(statusService.save(statusMapper.statusDtoToStatus(statusViewDTO)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") UUID id) {
        statusService.deleteById(id);
    }
}
