package com.velheor.internship.clients;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.velheor.internship.models.Currency;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
@PropertySource("classpath:currency.properties")
public class CurrencyClient {

    private final RestTemplate restTemplate;
    private final Environment env;

    public List<Currency> getAllCurrenciesFromUrls() {
        List<Currency> currencies = new ArrayList<>();
        currencies.add(getCurrencyByUrl("CURRENCY_URL_USD"));
        currencies.add(getCurrencyByUrl("CURRENCY_URL_EUR"));
        currencies.add(getCurrencyByUrl("CURRENCY_URL_RUB"));
        return currencies;
    }

    private Currency getCurrencyByUrl(String url){
        String urlResult = env.getProperty(url);
        return restTemplate.getForObject(Objects.requireNonNull(urlResult), Currency.class);
    }
}
