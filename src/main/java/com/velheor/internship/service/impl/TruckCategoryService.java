package com.velheor.internship.service.impl;

import com.velheor.internship.models.TruckCategory;
import com.velheor.internship.repository.TruckCategoryRepository;
import com.velheor.internship.service.api.ITruckCategoryService;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TruckCategoryService implements ITruckCategoryService {

    private final TruckCategoryRepository truckCategoryRepository;

    @Override
    public TruckCategory findById(Integer id) {
        return truckCategoryRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "TruckCategory with id: " + id + " was not found."));
    }

    @Override
    public TruckCategory create(TruckCategory truckCategory) {
        return truckCategoryRepository.save(truckCategory);
    }

    @Override
    public TruckCategory update(TruckCategory truckCategory) {
        return truckCategoryRepository.save(truckCategory);
    }

    @Override
    public List<TruckCategory> getAll() {
        return truckCategoryRepository.findAll();
    }

    @Override
    public void delete(TruckCategory truckCategory) {
        truckCategoryRepository.delete(truckCategory);
    }
}
