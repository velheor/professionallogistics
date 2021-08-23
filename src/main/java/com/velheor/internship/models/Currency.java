package com.velheor.internship.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "currencies")
@Data
@EqualsAndHashCode(callSuper = true)
public class Currency extends BaseEntity {

    private String currency;

    private BigDecimal amount;
}
