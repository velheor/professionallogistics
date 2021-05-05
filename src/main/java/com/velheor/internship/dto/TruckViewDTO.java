package com.velheor.internship.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class TruckViewDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    @Size(min = 2, max = 12, message = "{notCorrectSize}")
    private String name;

    @NotNull(message = "{notEmpty}")
    @Size(min = 9, max = 9, message = "{notCorrectSize}")
    private String registrationNumber;

    @NotNull(message = "{notEmpty}")
    @DecimalMin(value = "0.05", message = "{notCorrectWeight}")
    @DecimalMax(value = "200", message = "{notCorrectWeight}")
    @Digits(integer = 3, fraction = 2, message = "{notCorrectDigits}")
    private BigDecimal maxWeight;

    @NotNull(message = "{notEmpty}")
    @Size(min = 2, max = 45, message = "{notCorrectSize}")
    private String truckCategory;
}
