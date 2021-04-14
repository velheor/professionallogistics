package com.velheor.internship.dto;

import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

@Getter
@Setter
public class LoadDTO extends BaseDTO {

    @NotNull(message = "{name.notEmpty}")
    private String name;

    @NotNull(message = "{weight.notEmpty}")
    private BigDecimal weight;

    @NotNull(message = "{details.notEmpty}")
    @Min(value = 20, message = "{min.symbol}")
    private String description;
}
