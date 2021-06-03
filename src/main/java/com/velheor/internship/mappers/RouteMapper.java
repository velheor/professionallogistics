package com.velheor.internship.mappers;

import com.velheor.internship.dto.RouteDto;
import com.velheor.internship.models.Route;

public abstract class RouteMapper {

    public abstract RouteDto routeToRouteDto();

    public abstract Route routeDtoToRoute();
}
