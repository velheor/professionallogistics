package com.startup.raccoontruck.repos;

import com.startup.raccoontruck.domain.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TripRepo extends CrudRepository<Trip, Long> {
    List<Trip> findByPrice(Long price);
    List<Trip> findByCityFrom(String cityFrom);
    List<Trip> findByCityTo(String cityTo);
    List<Trip> findByWeight(Long weight);
}
