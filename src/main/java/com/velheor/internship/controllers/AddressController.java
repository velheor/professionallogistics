package com.velheor.internship.controllers;

import com.velheor.internship.dto.AddressDTO;
import com.velheor.internship.mappers.AddressMapper;
import com.velheor.internship.service.AddressService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @GetMapping("/{id}")
    public AddressDTO findById(@PathVariable("id") UUID id) {
        return addressMapper.addressToAddressDto(addressService.findById(id));
    }

    @PutMapping
    public AddressDTO update(@RequestBody AddressDTO AddressDTO) {
        addressService.save(addressMapper.addressDtoToAddress(AddressDTO));
        return AddressDTO;
    }

    @PostMapping
    public AddressDTO save(@RequestBody AddressDTO AddressDTO) {
        addressService.save(addressMapper.addressDtoToAddress(AddressDTO));
        return AddressDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        addressService.deleteById(id);
    }
}
