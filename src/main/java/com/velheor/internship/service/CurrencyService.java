package com.velheor.internship.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.velheor.internship.models.Rate;
import com.velheor.internship.models.Rates;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class CurrencyService {

    private static final String POSTS_API_URL = "http://data.fixer.io/api/latest?access_key=706c24d1c5aa4201e00909c13506b5ba&format=1";

    @SneakyThrows
    public List<Rate> getCurrentCurrency() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POSTS_API_URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        Rates currencies = mapper.readValue(response.body(), new TypeReference<>() {
        });


        currencies.getRates().forEach((key, value) -> System.out.println(key));
        return null;
    }

}
