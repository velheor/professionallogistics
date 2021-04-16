package com.velheor.internship.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderDTO extends BaseDTO {

    @NotNull(message = "notEmpty")
    private String datePickup;

    @NotNull(message = "notEmpty")
    private String dateDelivery;

    @NotNull(message = "notEmpty")
    private String price;

    private String voucherPickup;

    private String voucherDelivery;

    @NotNull(message = "notEmpty")
    private String truckCategory;

    private Iterable<LoadDTO> loadsDTO;

    private Iterable<StatusDTO> statusesDTO;

    private Iterable<RouteDTO> routesDTO;

    private UserDTO carrierDTO;

    private UserDTO shipperDTO;
}
