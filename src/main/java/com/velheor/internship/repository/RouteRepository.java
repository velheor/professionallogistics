package com.velheor.internship.repository;

import com.velheor.internship.models.Route;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RouteRepository extends CrudRepository<Route, UUID> {

}
