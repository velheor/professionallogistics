package com.velheor.internship.service.impl;

import com.velheor.internship.models.LoadCategory;
import com.velheor.internship.repository.LoadCategoryRepository;
import com.velheor.internship.service.api.ILoadCategoryService;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoadCategoryService implements ILoadCategoryService {

    private final LoadCategoryRepository loadCategoryRepository;

    @Override
    public LoadCategory findById(Integer id) {
        return loadCategoryRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    @Override
    public LoadCategory create(LoadCategory loadCategory) {
        return loadCategoryRepository.save(loadCategory);
    }

    @Override
    public LoadCategory update(LoadCategory loadCategory) {
        return loadCategoryRepository.save(loadCategory);
    }

    @Override
    public List<LoadCategory> getAll() {
        return loadCategoryRepository.findAll();
    }

    @Override
    public void delete(LoadCategory loadCategory) {
        loadCategoryRepository.delete(loadCategory);
    }
}
