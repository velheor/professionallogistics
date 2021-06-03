package com.velheor.internship.mappers;

import com.velheor.internship.dto.LoadViewDto;
import com.velheor.internship.models.Load;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class LoadMapper {

    public abstract LoadViewDto toLoadDto(Load load);

    public abstract Load toLoad(LoadViewDto loadViewDTO);
}
