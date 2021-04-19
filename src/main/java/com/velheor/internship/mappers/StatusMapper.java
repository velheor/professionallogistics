package com.velheor.internship.mappers;

import com.velheor.internship.dto.StatusViewDTO;
import com.velheor.internship.models.Status;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    StatusViewDTO statusToStatusDto(Status status);

    Status statusDtoToStatus(StatusViewDTO statusViewDTO);
}
