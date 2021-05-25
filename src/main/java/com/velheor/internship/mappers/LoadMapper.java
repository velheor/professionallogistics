package com.velheor.internship.mappers;

import com.velheor.internship.dto.LoadViewDTO;
import com.velheor.internship.models.Load;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class LoadMapper {

    public abstract LoadViewDTO toLoadDto(Load load);

    public abstract Load toLoad(LoadViewDTO loadViewDTO);
}
