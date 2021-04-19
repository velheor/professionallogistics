package com.velheor.internship.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class LoadViewDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    @Size(min = 5, message = "{notCorrectSize}")
    private String name;

    @NotNull(message = "{notEmpty}")
    private String weight;

    @NotNull(message = "{notEmpty}")
    @Size(min = 20, message = "{notCorrectSize}")
    private String description;
}
