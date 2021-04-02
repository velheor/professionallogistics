package com.velheor.internship.service.api;

import java.util.List;

public interface Crud<T> {

    T create(T t);

    T update(T t);

    List<T> getAll();

    void delete(T t);
}
