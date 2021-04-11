package com.velheor.internship.service;

import com.velheor.internship.models.Truck;
import com.velheor.internship.repository.TruckRepository;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TruckService {

    private final TruckRepository truckRepository;

    public Truck findById(UUID id) {
        return truckRepository.findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException(
                    "Truck with id: " + id.toString() + " was not found."));
    }

    public Truck create(Truck truck) {
        return truckRepository.save(truck);
    }

    public Truck update(Truck truck) {
        return truckRepository.save(truck);
    }

    public Iterable<Truck> getAll() {
        return truckRepository.findAll();
    }

    public void delete(Truck truck) {
        truckRepository.delete(truck);
    }
}
