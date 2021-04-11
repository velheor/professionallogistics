package com.velheor.internship.service;

import com.velheor.internship.models.TruckCategory;
import com.velheor.internship.repository.TruckCategoryRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TruckCategoryService {

    private final TruckCategoryRepository truckCategoryRepository;

    public TruckCategory findById(Integer id) {
        return truckCategoryRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "TruckCategory with id: " + id + " was not found."));
    }

    public TruckCategory create(TruckCategory truckCategory) {
        return truckCategoryRepository.save(truckCategory);
    }

    public TruckCategory update(TruckCategory truckCategory) {
        return truckCategoryRepository.save(truckCategory);
    }

    public List<TruckCategory> getAll() {
        return truckCategoryRepository.findAll();
    }

    public void delete(TruckCategory truckCategory) {
        truckCategoryRepository.delete(truckCategory);
    }
}
