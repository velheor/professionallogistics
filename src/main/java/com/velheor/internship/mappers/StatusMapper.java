package com.velheor.internship.mappers;

import com.velheor.internship.dto.StatusViewDto;
import com.velheor.internship.models.Status;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StatusMapper {

    public abstract StatusViewDto toStatusViewDto(Status status);

    public abstract Status toStatus(StatusViewDto statusViewDTO);
}
