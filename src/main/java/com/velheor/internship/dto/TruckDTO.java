package com.velheor.internship.dto;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TruckDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    private String name;

    @NotNull(message = "{notEmpty}")
    private String registrationNumber;

    @NotNull(message = "{notEmpty}")
    private BigDecimal maxWeight;

    @NotNull(message = "{notEmpty}")
    private String truckCategory;
}
