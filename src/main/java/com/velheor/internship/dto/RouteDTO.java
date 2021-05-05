package com.velheor.internship.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RouteDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    private AddressViewDTO addressTo;

    @NotNull(message = "{notEmpty}")
    private AddressViewDTO addressFrom;
}
