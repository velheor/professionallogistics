package com.velheor.internship.service;

import com.velheor.internship.models.Load;
import com.velheor.internship.repository.LoadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LoadService {

    private final LoadRepository loadRepository;

    public Load findById(UUID id) {
        return loadRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Load with id: " + id + " was not found."));
    }

    public Load save(Load load) {
        return loadRepository.save(load);
    }

    public Iterable<Load> getAll() {
        return loadRepository.findAll();
    }

    public void deleteById(UUID id) {
        loadRepository.deleteById(id);
    }
}
