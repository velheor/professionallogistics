package com.startup.raccoontruck.repos;

import com.startup.raccoontruck.domain.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TripRepo extends CrudRepository<Trip, Long> {
    List<Trip> findByPriceAndCityFromAndCityToAndWeight(String cityFrom, String cityTo, String price, String weight);
}
