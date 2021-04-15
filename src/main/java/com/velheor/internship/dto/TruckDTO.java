package com.velheor.internship.dto;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class TruckDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    @Size(min = 2, max = 12, message = "notCorrectSize}")
    private String name;

    @NotNull(message = "{notEmpty}")
    @Size(min = 9, max = 9, message = "notCorrectSize}")
    private String registrationNumber;

    @NotNull(message = "{notEmpty}")
    private BigDecimal maxWeight;

    @NotNull(message = "{notEmpty}")
    private String truckCategory;
}
