package com.velheor.internship.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class LoadDTO extends BaseDTO {

    @NotNull(message = "notEmpty")
    private String name;

    @NotNull(message = "notEmpty")
    private String weight;

    @NotNull(message = "notEmpty")
    @Size(min = 20, message = "notCorrectSize")
    private String description;
}
