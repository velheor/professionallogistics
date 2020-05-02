package com.startup.raccoontruck.repos;

import com.startup.raccoontruck.domain.Load;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoadRepo extends CrudRepository<Load, Long> {
    List<Load> findByCityFromOrCityToOrWeightOrPrice(String cityFrom, String cityTo, String weight, String price);
    List<Load> findByDriverId(Long driverId);
}
