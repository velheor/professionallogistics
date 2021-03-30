package com.velheor.internship.repository;

import com.velheor.internship.models.StatusHistory;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface StatusHistoryRepository extends CrudRepository<StatusHistory, UUID> {

    @Override
    List<StatusHistory> findAll();
}
