package com.velheor.internship.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddressDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    private String country;

    @NotNull(message = "{notEmpty}")
    private String city;

    @NotNull(message = "{notEmpty}")
    private String streetName;

    @NotNull(message = "{notEmpty}")
    private String streetNumber;
}
