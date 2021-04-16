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

    @NotNull(message = "notEmpty")
    private Iterable<LoadDTO> loadsDTO;

    @NotNull(message = "notEmpty")
    private Iterable<StatusDTO> statusesDTO;

    @NotNull(message = "notEmpty")
    private Iterable<RouteDTO> routesDTO;

    private UserDTO carrierDTO;

    @NotNull(message = "notEmpty")
    private UserDTO shipperDTO;
}
