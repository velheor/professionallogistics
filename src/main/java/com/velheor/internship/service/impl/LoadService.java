package com.velheor.internship.service.impl;

import com.velheor.internship.models.Load;
import com.velheor.internship.repository.LoadRepository;
import com.velheor.internship.service.api.ILoadService;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoadService implements ILoadService {

    private final LoadRepository loadRepository;

    @Override
    public Load findById(UUID id) {
        return loadRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "Load with id: " + id.toString() + " was not found."));
    }

    @Override
    public Load create(Load load) {
        return loadRepository.save(load);
    }

    @Override
    public Load update(Load load) {
        return loadRepository.save(load);
    }

    @Override
    public List<Load> getAll() {
        return loadRepository.findAll();
    }

    @Override
    public void delete(Load load) {
        loadRepository.delete(load);
    }
}
