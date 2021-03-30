package com.velheor.internship.service.api;

import java.util.List;

public interface Crud<Entity> {

    Entity create(Entity entity);

    Entity update(Entity entity);

    List<Entity> getAll();

    void delete(Entity entity);
}
