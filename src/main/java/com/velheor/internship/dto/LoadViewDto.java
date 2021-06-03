package com.velheor.internship.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class LoadViewDto extends BaseDto {

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

    public LoadViewDto(LoadViewDto loadViewDTO) {
        super.setId(loadViewDTO.getId());
        name = loadViewDTO.getName();
        weight = loadViewDTO.getWeight();
        details = loadViewDTO.getDetails();
    }
}
