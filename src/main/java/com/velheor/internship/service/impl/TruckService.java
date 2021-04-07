package com.velheor.internship.service.impl;

import com.velheor.internship.models.Truck;
import com.velheor.internship.repository.TruckRepository;
import com.velheor.internship.service.api.ITruckService;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TruckService implements ITruckService {

    private final TruckRepository truckRepository;

    @Override
    public Truck findById(UUID id) {
        return truckRepository.findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Truck with id: " + id.toString() + " was not found."));
    }

    @Override
    public Truck create(Truck truck) {
        return truckRepository.save(truck);
    }

    @Override
    public Truck update(Truck truck) {
        return truckRepository.save(truck);
    }

    @Override
    public List<Truck> getAll() {
        return truckRepository.findAll();
    }

    @Override
    public void delete(Truck truck) {
        truckRepository.delete(truck);
    }
}
