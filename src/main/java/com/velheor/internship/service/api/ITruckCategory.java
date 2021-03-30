package com.velheor.internship.service.api;

import com.velheor.internship.models.TruckCategory;

public interface ITruckCategory extends Crud<TruckCategory> {

    TruckCategory findById(Integer id);
}
