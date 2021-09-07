package com.velheor.internship.service;

import com.velheor.internship.models.Rate;
import com.velheor.internship.repository.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class RateService {

    private final RateRepository rateRepository;

    public Rate findByNameAndCurrencyName(String from, String to) {
        return rateRepository.findByNameAndCurrencyName(from, to)
                .orElseThrow(() -> new EntityNotFoundException("Rate with name" + from + "and currency name " + to + "not found"));
    }
}
