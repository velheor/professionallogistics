package com.velheor.internship.mappers;

import com.velheor.internship.dto.StatusDTO;
import com.velheor.internship.models.Status;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    StatusDTO statusToStatusDto(Status status);

    Status statusDtoToStatus(StatusDTO statusDTO);
}
