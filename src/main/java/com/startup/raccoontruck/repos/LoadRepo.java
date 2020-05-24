package com.startup.raccoontruck.repos;

import com.startup.raccoontruck.domain.Load;
import com.startup.raccoontruck.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoadRepo extends CrudRepository<Load, Long> {
    List<Load> findByCityFromOrCityToOrWeightOrPrice(String cityFrom, String cityTo, String weight, String price);

    List<Load> findByDriverId(Long driverId);

    List<Load> findByDriverIdAndStatus(Long driverId, Boolean status);

    List<Load> findByCustomerAndStatus(User customer, Boolean status);
}
