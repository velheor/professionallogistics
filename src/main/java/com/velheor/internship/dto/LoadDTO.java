package com.velheor.internship.dto;

import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoadDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    private String name;

    @NotNull(message = "{notEmpty}")
    private BigDecimal weight;

    @NotNull(message = "{notEmpty}")
    @Min(value = 20, message = "{min.symbol}")
    private String description;
}
