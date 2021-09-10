package com.velheor.internship.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "rates")
@Getter
@Setter
@NoArgsConstructor
@NamedEntityGraph(
        name = "RateWithCurrency",
        attributeNodes = {
                @NamedAttributeNode(value = "currency")
        }
)
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

    @Override
    public String toString() {
        return "Rate{" + "name='" + name + '\'' + ", exchangeRate=" + exchangeRate + '}';
    }
}
