package com.velheor.internship.service;

import com.velheor.internship.models.Load;
import com.velheor.internship.repository.LoadRepository;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoadService {

    private final LoadRepository loadRepository;

    public Load findById(UUID id) {
        return loadRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "Load with id: " + id.toString() + " was not found."));
    }

    public Load create(Load load) {
        return loadRepository.save(load);
    }

    public Load update(Load load) {
        return loadRepository.save(load);
    }

    public List<Load> getAll() {
        return loadRepository.findAll();
    }

    public void delete(Load load) {
        loadRepository.delete(load);
    }
}
