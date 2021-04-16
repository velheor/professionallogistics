package com.velheor.internship.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RouteDTO extends BaseDTO {

    @NotNull(message = "notEmpty")
    private AddressDTO addressTo;

    @NotNull(message = "notEmpty")
    private AddressDTO addressFrom;
}
