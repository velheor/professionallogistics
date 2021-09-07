package com.velheor.internship.mappers;

import com.velheor.internship.dto.CostViewDto;
import com.velheor.internship.models.Cost;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CostMapper {

    public abstract Iterable<CostViewDto> toCostViewDto(Iterable<Cost> costs);
}
