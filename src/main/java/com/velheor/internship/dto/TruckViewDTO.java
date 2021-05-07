package com.velheor.internship.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class TruckViewDTO extends BaseDTO {

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 2, max = 12, message = "{notCorrectSize}")
    private String name;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 9, max = 9, message = "{notCorrectSize}")
    private String registrationNumber;

    @NotNull(message = "{notEmpty}")
    @DecimalMin(value = "0.05", message = "{notCorrectWeight}")
    @DecimalMax(value = "30", message = "{notCorrectWeight}")
    private BigDecimal maxWeight;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 2, max = 45, message = "{notCorrectSize}")
    private String truckCategory;

    public TruckViewDTO(TruckViewDTO truckViewDTO){
        setId(truckViewDTO.getId());
        name = truckViewDTO.getName();
        registrationNumber = truckViewDTO.getRegistrationNumber();
        maxWeight = truckViewDTO.getMaxWeight();
        truckCategory = truckViewDTO.getTruckCategory();
    }
}
