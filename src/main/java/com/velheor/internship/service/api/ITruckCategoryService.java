package com.velheor.internship.service.api;

import com.velheor.internship.models.TruckCategory;

public interface ITruckCategoryService extends Crud<TruckCategory> {

    TruckCategory findById(Integer id);
}
