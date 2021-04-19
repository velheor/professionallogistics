package com.velheor.internship.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class AddressViewDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    @Size(min = 2, max = 20, message = "{notCorrectSize}")
    private String country;

    @NotNull(message = "{notEmpty}")
    @Size(min = 2, max = 25, message = "{notCorrectSize}")
    private String city;

    @NotNull(message = "{notEmpty}")
    @Size(min = 2, max = 25, message = "{notCorrectSize}")
    private String streetName;

    @NotNull(message = "{notEmpty}")
    @Size(min = 2, max = 10, message = "{notCorrectSize}")
    private String streetNumber;
}
