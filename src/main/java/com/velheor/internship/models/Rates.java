package com.velheor.internship.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.velheor.internship.mappers.RateDeserializer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Rates {

    @JsonDeserialize(using = RateDeserializer.class)
    private List<Rate> rates;
}
