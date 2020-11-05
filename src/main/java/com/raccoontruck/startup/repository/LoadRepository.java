package com.raccoontruck.startup.repository;

import com.raccoontruck.startup.models.Load;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoadRepository extends CrudRepository<Load, Long> {
    List<Load> findAll();
}