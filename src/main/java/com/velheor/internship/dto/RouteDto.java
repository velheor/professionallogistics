package com.velheor.internship.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RouteDto extends BaseDto {

    @NotNull(message = "{notEmpty}")
    private AddressViewDto addressTo;

    @NotNull(message = "{notEmpty}")
    private AddressViewDto addressFrom;
}
