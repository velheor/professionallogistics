package com.velheor.internship.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class LoadViewDTO extends BaseDTO {

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 5, max = 45, message = "{notCorrectSize}")
    private String name;

    @NotNull(message = "{notEmpty}")
    @DecimalMin(value = "0.05", message = "{notCorrectWeight}")
    @DecimalMax(value = "30", message = "{notCorrectWeight}")
    private BigDecimal weight;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 20, max = 255, message = "{notCorrectSize}")
    private String details;

    public LoadViewDTO(LoadViewDTO loadViewDTO){
        super.setId(loadViewDTO.getId());
        name = loadViewDTO.getName();
        weight = loadViewDTO.getWeight();
        details = loadViewDTO.getDetails();
    }
}
