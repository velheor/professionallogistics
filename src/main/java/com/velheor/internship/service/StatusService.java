package com.velheor.internship.service;

import com.velheor.internship.models.Status;
import com.velheor.internship.repository.StatusRepository;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatusService {

    private final StatusRepository statusRepository;

    public Status findById(UUID id) {
        return statusRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "StatusHistory with id: " + id.toString() + " was not found."));
    }

    public Status create(Status status) {
        return statusRepository.save(status);
    }

    public Status update(Status status) {
        return statusRepository.save(status);
    }

    public Iterable<Status> getAll() {
        return statusRepository.findAll();
    }

    public void delete(Status status) {
        statusRepository.delete(status);
    }
}
