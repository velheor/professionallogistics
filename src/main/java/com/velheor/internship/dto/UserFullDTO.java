package com.velheor.internship.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UserFullDTO extends UserViewDTO {

    @NotNull(message = "{notEmpty}")
    private TruckViewDTO truck;

    @NotNull(message = "{notEmpty}")
    private List<OrderViewDTO> shipperOrders;

    @NotNull(message = "{notEmpty}")
    private List<OrderViewDTO> carrierOrders;

    @NotNull(message = "{notEmpty}")
    private List<String> roles;
}
