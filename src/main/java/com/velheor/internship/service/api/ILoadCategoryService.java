package com.velheor.internship.service.api;

import com.velheor.internship.models.LoadCategory;

public interface ILoadCategoryService extends Crud<LoadCategory> {

    LoadCategory findById(Integer id);
}
