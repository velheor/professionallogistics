package com.velheor.internship.repository;

import com.velheor.internship.models.Route;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface RouteRepository extends CrudRepository<Route, UUID> {

}
