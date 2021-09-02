package com.velheor.internship.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Entity
@Table(name = "rates")
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Rate {

    @Id
    private String name;

    @Column(name =  "exchange_rate")
    private BigDecimal exchangeRate;

    public Rate(String both){
        String[] pairs = both.split(":");
        this.name = pairs[0];
        this.exchangeRate = new BigDecimal(pairs[1]).setScale(2, RoundingMode.HALF_UP);
    }
}
