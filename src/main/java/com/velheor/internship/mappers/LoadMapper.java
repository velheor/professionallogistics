package com.velheor.internship.mappers;

import com.velheor.internship.dto.LoadDTO;
import com.velheor.internship.models.Load;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoadMapper {

    LoadDTO loadToLoadDTO(Load load);
}
