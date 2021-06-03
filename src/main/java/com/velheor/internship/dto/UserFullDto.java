package com.velheor.internship.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UserFullDto extends UserViewDto {

    @NotNull(message = "{notEmpty}")
    private TruckViewDto truck;

    @NotNull(message = "{notEmpty}")
    private List<OrderViewDto> shipperOrders;

    @NotNull(message = "{notEmpty}")
    private List<OrderViewDto> carrierOrders;

    @NotNull(message = "{notEmpty}")
    private List<String> roles;
}
