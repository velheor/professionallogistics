package com.velheor.internship.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CostViewDto {
    private String currencyName;
    private BigDecimal amount;
    private OrderViewDto order;
}
