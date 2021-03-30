package com.velheor.internship.repository;

import com.velheor.internship.models.StatusHistory;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StatusHistoryRepository extends CrudRepository<StatusHistory, Integer> {

    @Override
    List<StatusHistory> findAll();
}
