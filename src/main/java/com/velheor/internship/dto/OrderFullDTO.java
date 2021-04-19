package com.velheor.internship.dto;

import javax.validation.constraints.NotNull;

public class OrderFullDTO extends OrderViewDTO {

    @NotNull(message = "{notEmpty}")
    private Iterable<LoadViewDTO> loadsDTO;

    @NotNull(message = "{notEmpty}")
    private Iterable<StatusViewDTO> statusesDTO;

    @NotNull(message = "{notEmpty}")
    private Iterable<RouteDTO> routesDTO;

    private UserViewDTO carrierDTO;

    @NotNull(message = "{notEmpty}")
    private UserViewDTO shipperDTO;
}
