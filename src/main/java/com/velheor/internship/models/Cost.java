package com.velheor.internship.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "costs")
@Data
@EqualsAndHashCode
public class Cost {

    @Id
    private UUID id;

    private BigDecimal amount;

    @Column(name = "currency_name")
    private String currencyName;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Order order;
}
