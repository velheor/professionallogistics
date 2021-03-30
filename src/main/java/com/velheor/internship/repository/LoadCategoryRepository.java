package com.velheor.internship.repository;

import com.velheor.internship.models.LoadCategory;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LoadCategoryRepository extends CrudRepository<LoadCategory, Integer> {

    @Override
    List<LoadCategory> findAll();
}
