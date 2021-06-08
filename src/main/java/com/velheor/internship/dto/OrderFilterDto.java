package com.velheor.internship.dto;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderFilterDto {

    @DecimalMin(value = "1", message = "{notCorrectDigits}")
    private BigDecimal priceTo;

    @DecimalMin(value = "1", message = "{notCorrectDigits}")
    private BigDecimal priceFrom;

    private LocalDateTime dateTo;

    private LocalDateTime dateFrom;
}
