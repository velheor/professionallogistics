package com.velheor.internship.service;

import com.velheor.internship.models.StatusHistory;
import com.velheor.internship.repository.StatusHistoryRepository;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatusHistoryService {

    private final StatusHistoryRepository statusHistoryRepository;

    public StatusHistory findById(UUID id) {
        return statusHistoryRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "StatusHistory with id: " + id.toString() + " was not found."));
    }

    public StatusHistory create(StatusHistory statusHistory) {
        return statusHistoryRepository.save(statusHistory);
    }

    public StatusHistory update(StatusHistory statusHistory) {
        return statusHistoryRepository.save(statusHistory);
    }

    public List<StatusHistory> getAll() {
        return statusHistoryRepository.findAll();
    }

    public void delete(StatusHistory statusHistory) {
        statusHistoryRepository.delete(statusHistory);
    }
}
