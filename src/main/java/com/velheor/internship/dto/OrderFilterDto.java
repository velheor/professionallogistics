package com.velheor.internship.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderFilterDto {

    @DecimalMin(value = "1", message = "{notCorrectDigits}")
    private BigDecimal priceTo;

    @DecimalMin(value = "1", message = "{notCorrectDigits}")
    private BigDecimal priceFrom;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateFrom;
}
