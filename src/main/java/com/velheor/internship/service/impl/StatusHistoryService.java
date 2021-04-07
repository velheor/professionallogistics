package com.velheor.internship.service.impl;

import com.velheor.internship.models.StatusHistory;
import com.velheor.internship.repository.StatusHistoryRepository;
import com.velheor.internship.service.api.IStatusHistoryService;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatusHistoryService implements IStatusHistoryService {

    private final StatusHistoryRepository statusHistoryRepository;

    @Override
    public StatusHistory findById(UUID id) {
        return statusHistoryRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "StatusHistory with id: " + id.toString() + " was not found."));
    }

    @Override
    public StatusHistory create(StatusHistory statusHistory) {
        return statusHistoryRepository.save(statusHistory);
    }

    @Override
    public StatusHistory update(StatusHistory statusHistory) {
        return statusHistoryRepository.save(statusHistory);
    }

    @Override
    public List<StatusHistory> getAll() {
        return statusHistoryRepository.findAll();
    }

    @Override
    public void delete(StatusHistory statusHistory) {
        statusHistoryRepository.delete(statusHistory);
    }
}
