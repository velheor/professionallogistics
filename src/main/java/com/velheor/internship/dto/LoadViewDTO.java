package com.velheor.internship.dto;

import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class LoadViewDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    @Size(min = 5, max = 45, message = "{notCorrectSize}")
    private String name;

    @NotNull(message = "{notEmpty}")
    @DecimalMin(value = "0.05", inclusive = false, message = "{notCorrectWeight}")
    private BigDecimal weight;

    @NotNull(message = "{notEmpty}")
    @Size(min = 20, max = 255, message = "{notCorrectSize}")
    private String description;
}
