package com.velheor.internship.mappers;

import com.velheor.internship.dto.AddressDTO;
import com.velheor.internship.models.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO addressToAddressDto(Address address);

    Address addressDtoToAddress(AddressDTO addressDTO);
}
