package com.velheor.internship.mappers;

import com.velheor.internship.dto.LoadViewDTO;
import com.velheor.internship.models.Load;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoadMapper {

    LoadViewDTO loadToLoadDto(Load load);

    Load loadDtoToLoad(LoadViewDTO loadViewDTO);
}
