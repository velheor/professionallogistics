package com.velheor.internship.service.api;

import com.velheor.internship.models.LoadCategory;
import java.util.UUID;

public interface ILoadCategoryService extends Crud<LoadCategory> {

    LoadCategory findById(UUID id);
}
