package com.velheor.internship.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.velheor.internship.clients.CurrencyClient;
import com.velheor.internship.models.Cost;
import com.velheor.internship.models.Currency;
import com.velheor.internship.models.Rate;
import com.velheor.internship.repository.CurrencyRepository;
import com.velheor.internship.repository.RateRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyClient currencyClient;

    public Currency findByName(String name) {
        return currencyRepository.findById(name).orElseThrow(() ->
                new EntityNotFoundException("Currency with name " + name + " not found"));
    }

    public void updateCurrentCurrenciesRates() {
        List<Currency> currencies = currencyClient.getAllCurrenciesFromUrls();
        currencies.forEach(currency -> currency.getRates()
                .forEach(rate -> rate.setCurrency(currency)));
        currencyRepository.saveAll(currencies);
    }
}
