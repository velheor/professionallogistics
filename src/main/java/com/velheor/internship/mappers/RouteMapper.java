package com.velheor.internship.mappers;

import com.velheor.internship.dto.RouteDTO;
import com.velheor.internship.models.Route;

public abstract class RouteMapper {

    public abstract RouteDTO routeToRouteDto();

    public abstract Route routeDtoToRoute();
}
