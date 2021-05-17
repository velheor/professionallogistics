package com.velheor.internship.service;

import com.velheor.internship.models.Status;
import com.velheor.internship.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StatusService {

    private final StatusRepository statusRepository;

    public Status findById(UUID id) {
        return statusRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Status with id: " + id + " was not found."));
    }

    public Status save(Status status) {
        return statusRepository.save(status);
    }

    public Iterable<Status> getAll() {
        return statusRepository.findAll();
    }

    public void deleteById(UUID id) {
        statusRepository.deleteById(id);
    }
}
