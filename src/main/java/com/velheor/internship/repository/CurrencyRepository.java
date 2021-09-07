package com.velheor.internship.repository;

import com.velheor.internship.models.Currency;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CurrencyRepository extends CrudRepository<Currency, String> {

    @EntityGraph("CurrencyWithRates")
    Optional<Currency> findById(String id);
}
