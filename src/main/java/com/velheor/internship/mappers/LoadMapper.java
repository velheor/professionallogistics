package com.velheor.internship.mappers;

import com.velheor.internship.dto.LoadViewDTO;
import com.velheor.internship.models.Load;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class LoadMapper {

    public abstract LoadViewDTO loadToLoadDto(Load load);

    public abstract Load loadDtoToLoad(LoadViewDTO loadViewDTO);
}
