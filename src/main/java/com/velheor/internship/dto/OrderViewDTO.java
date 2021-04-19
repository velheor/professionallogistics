package com.velheor.internship.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderViewDTO extends BaseDTO {

    @NotNull(message = "{notEmpty}")
    private String datePickup;

    @NotNull(message = "{notEmpty}")
    private String dateDelivery;

    @NotNull(message = "{notEmpty}")
    private String price;

    @NotNull(message = "{notEmpty}")
    private String truckCategory;
}
