package com.velheor.internship.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;

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
