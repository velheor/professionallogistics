package com.raccoontruck.startup;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoadRepository extends CrudRepository<Load, Long> {
    List<Load> findAll();
}