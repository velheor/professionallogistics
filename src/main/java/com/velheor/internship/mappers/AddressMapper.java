package com.velheor.internship.mappers;

import com.velheor.internship.dto.AddressViewDto;
import com.velheor.internship.models.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AddressMapper {

    public abstract AddressViewDto toAddressDto(Address address);

    public abstract Address toAddress(AddressViewDto addressViewDTO);
}
