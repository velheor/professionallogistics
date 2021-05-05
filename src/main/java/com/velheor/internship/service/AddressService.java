package com.velheor.internship.service;

import com.velheor.internship.models.Address;
import com.velheor.internship.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Address findById(UUID id) {
        return addressRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Address with id: " + id + " was not found."));
    }

    public Address save(Address address) {
        return addressRepository.save(
                address);
    }

    public Iterable<Address> getAll() {
        return addressRepository.findAll();
    }

    public void deleteById(UUID id) {
        addressRepository.deleteById(id);
    }
}
