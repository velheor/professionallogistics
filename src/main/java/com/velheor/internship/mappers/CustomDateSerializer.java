package com.velheor.internship.mappers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class CustomDateSerializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        Instant instant = Instant.ofEpochSecond(p.getValueAsLong());
        ZoneId zoneId = ZoneId.of("GMT");
        return LocalDateTime.ofInstant(instant, zoneId);
    }
}
