package com.velheor.internship.mappers;

import com.velheor.internship.dto.StatusViewDTO;
import com.velheor.internship.models.Status;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StatusMapper {

    public abstract StatusViewDTO statusToStatusDto(Status status);

    public abstract Status statusDtoToStatus(StatusViewDTO statusViewDTO);
}
