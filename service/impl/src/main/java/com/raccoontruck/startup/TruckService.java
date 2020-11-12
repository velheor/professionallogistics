package com.raccoontruck.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckService implements ITruckService {

    private final TruckRepository truckRepository;

    @Autowired
    TruckService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    @Override
    public List<TruckDTO> findAll() {
        return convertToDTO(truckRepository.findAll());
    }

    @Override
    public TruckDTO findById(Long id) {
        return null;
    }

    @Override
    public TruckDTO update(TruckDTO truckDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TruckDTO convertToDTO(Truck truck) {
        return ObjectMapperUtils.map(truck, TruckDTO.class);
    }

    @Override
    public Truck convertFromDTO(TruckDTO truckDTO) {
        return ObjectMapperUtils.map(truckDTO, Truck.class);
    }

    @Override
    public List<TruckDTO> convertToDTO(List<Truck> trucks) {
        return ObjectMapperUtils.mapAll(trucks, TruckDTO.class);

    }

    @Override
    public List<Truck> convertFromDTO(List<TruckDTO> truckDTOS) {
        return ObjectMapperUtils.mapAll(truckDTOS, Truck.class);
    }
}