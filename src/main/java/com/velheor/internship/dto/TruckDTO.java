package com.velheor.internship.dto;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TruckDTO extends BaseDTO {

    @NotNull(message = "{truckName.notEmpty}")
    private String name;

    @NotNull(message = "{registrationNumber.notEmpty}")
    private String registrationNumber;

    @NotNull(message = "{maxWeight.notEmpty}")
    private BigDecimal maxWeight;

    @NotNull(message = "{truckCategory.notEmpty}")
    private String truckCategory;
}
