package com.velheor.internship.repository;

import com.velheor.internship.models.Rate;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface RateRepository extends CrudRepository<Rate, UUID> {

    Optional<Rate> findByNameAndCurrencyId(String name, UUID currencyId);

}
