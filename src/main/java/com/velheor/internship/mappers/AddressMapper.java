package com.velheor.internship.mappers;

import com.velheor.internship.dto.AddressViewDTO;
import com.velheor.internship.models.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AddressMapper {

    public abstract AddressViewDTO toAddressDto(Address address);

    public abstract Address toAddress(AddressViewDTO addressViewDTO);
}
