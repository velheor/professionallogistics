package com.velheor.internship.repository;

import com.velheor.internship.models.TruckCategory;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TruckCategoryRepository extends CrudRepository<TruckCategory, Integer> {

    @Override
    List<TruckCategory> findAll();
}
