package com.velheor.internship.dto;

import javax.validation.constraints.NotNull;

public class OrderFullDto extends OrderViewDto {

    @NotNull(message = "{notEmpty}")
    private Iterable<LoadViewDto> loadsDTO;

    @NotNull(message = "{notEmpty}")
    private Iterable<StatusViewDto> statusesDTO;

    @NotNull(message = "{notEmpty}")
    private Iterable<RouteDto> routesDTO;

    private UserViewDto carrierDTO;

    @NotNull(message = "{notEmpty}")
    private UserViewDto shipperDTO;
}
