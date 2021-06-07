package com.velheor.internship.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TruckViewDto extends BaseDto {

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

    public TruckViewDto(TruckViewDto truckViewDTO) {
        setId(truckViewDTO.getId());
        name = truckViewDTO.getName();
        registrationNumber = truckViewDTO.getRegistrationNumber();
        maxWeight = truckViewDTO.getMaxWeight();
        truckCategory = truckViewDTO.getTruckCategory();
    }
}
