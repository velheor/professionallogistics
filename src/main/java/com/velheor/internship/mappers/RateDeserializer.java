package com.velheor.internship.mappers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.velheor.internship.models.Rate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RateDeserializer extends JsonDeserializer<List<Rate>> {

    @Override
    public List<Rate> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        List<Rate> rates = new ArrayList<>();

        ObjectCodec codec = p.getCodec();
        JsonNode node = codec.readTree(p);

        node.fields().forEachRemaining(x -> rates.add(new Rate(x.getKey() + ":" + x.getValue().asText())));

        return rates;
    }
}
