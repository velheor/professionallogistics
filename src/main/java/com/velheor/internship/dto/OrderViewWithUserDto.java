package com.velheor.internship.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderViewWithUserDto extends OrderViewDto {

    @NotNull(message = "{notEmpty}")
    private UserViewDto carrier;

    private UserViewDto shipper;
}
