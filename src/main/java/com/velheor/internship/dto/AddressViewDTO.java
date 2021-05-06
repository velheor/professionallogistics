package com.velheor.internship.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AddressViewDTO extends BaseDTO {

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 2, max = 20, message = "{notCorrectSize}")
    private String country;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 2, max = 25, message = "{notCorrectSize}")
    private String city;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 2, max = 25, message = "{notCorrectSize}")
    private String streetName;

    @NotEmpty(message = "{notEmpty}")
    @Size(min = 2, max = 10, message = "{notCorrectSize}")
    private String streetNumber;
}
