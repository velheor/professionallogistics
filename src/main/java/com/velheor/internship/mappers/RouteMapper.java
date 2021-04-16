package com.velheor.internship.mappers;

import com.velheor.internship.dto.RouteDTO;
import com.velheor.internship.models.Route;

public interface RouteMapper {

    RouteDTO routeToRouteDto();

    Route routeDtoToRoute();
}
