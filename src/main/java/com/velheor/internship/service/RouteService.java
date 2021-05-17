package com.velheor.internship.service;

import com.velheor.internship.models.Route;
import com.velheor.internship.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;

    public Route findById(UUID id) {
        return routeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Route with id: " + id + " was not found."));
    }

    public Route save(Route route) {
        return routeRepository.save(route);
    }

    public Iterable<Route> getAll() {
        return routeRepository.findAll();
    }

    public void deleteById(UUID id) {
        routeRepository.deleteById(id);
    }
}
