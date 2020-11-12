package com.raccoontruck.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService implements IDriverService {

    private final DriverRepository driverRepository;

    @Autowired
    DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<DriverDTO> findAll() {
        return convertToDTO(driverRepository.findAll());
    }

    @Override
    public DriverDTO findById(Long id) {
        if (!driverRepository.findById(id).isPresent()) {
            return null;
        }
        return convertToDTO(driverRepository.findById(id).orElse(null));
    }

    @Override
    public DriverDTO update(DriverDTO driverDTO) {
        return convertToDTO(driverRepository.save(convertFromDTO(driverDTO)));
    }

    @Override
    public void delete(Long id) {
        driverRepository.delete(convertFromDTO(findById(id)));
    }

    @Override
    public DriverDTO convertToDTO(Driver driver) {
        return ObjectMapperUtils.map(driver, DriverDTO.class);
    }

    @Override
    public Driver convertFromDTO(DriverDTO driverDTO) {
        return ObjectMapperUtils.map(driverDTO, Driver.class);
    }

    @Override
    public List<DriverDTO> convertToDTO(List<Driver> drivers) {
        return ObjectMapperUtils.mapAll(drivers, DriverDTO.class);
    }

    @Override
    public List<Driver> convertFromDTO(List<DriverDTO> driverDTOS) {
        return ObjectMapperUtils.mapAll(driverDTOS, Driver.class);
    }
}