package com.velheor.internship.controllers;

import com.velheor.internship.dto.AddressViewDTO;
import com.velheor.internship.mappers.AddressMapper;
import com.velheor.internship.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @GetMapping("/{id}")
    public AddressViewDTO findById(@PathVariable("id") UUID id) {
        return addressMapper.addressToAddressDto(addressService.findById(id));
    }

    @PutMapping
    public AddressViewDTO update(@Valid @RequestBody AddressViewDTO AddressViewDTO) {
        return addressMapper.addressToAddressDto(
                addressService.save(addressMapper.addressDtoToAddress(AddressViewDTO)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressViewDTO save(@Valid @RequestBody AddressViewDTO AddressViewDTO) {
        return addressMapper.addressToAddressDto(
                addressService.save(addressMapper.addressDtoToAddress(AddressViewDTO)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") UUID id) {
        addressService.deleteById(id);
    }
}
