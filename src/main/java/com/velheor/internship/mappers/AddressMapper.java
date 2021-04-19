package com.velheor.internship.mappers;

import com.velheor.internship.dto.AddressViewDTO;
import com.velheor.internship.models.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressViewDTO addressToAddressDto(Address address);

    Address addressDtoToAddress(AddressViewDTO addressViewDTO);
}
