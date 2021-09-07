package com.velheor.internship.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "rates")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Rate extends BaseEntity {

    private String name;

    @Column(name = "exchange_rate")
    private BigDecimal exchangeRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currencies_id", referencedColumnName = "id")
    private Currency currency;

    public Rate(String both) {
        String[] pairs = both.split(":");
        this.name = pairs[0];
        this.exchangeRate = new BigDecimal(pairs[1]).setScale(6, RoundingMode.HALF_UP);
    }
}
