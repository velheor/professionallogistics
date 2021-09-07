package com.velheor.internship.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CostViewDto {
    private String currencyName;
    private BigDecimal amount;
    private OrderViewDto orderViewDto;
}
