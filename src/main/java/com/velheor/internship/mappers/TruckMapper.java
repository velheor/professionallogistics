package com.velheor.internship.mappers;

import com.velheor.internship.dto.TruckViewDto;
import com.velheor.internship.models.Truck;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class TruckMapper {

    public abstract TruckViewDto toTruckViewDto(Truck truck);

    public abstract Truck toTruck(TruckViewDto truckViewDTO);

    public abstract Iterable<TruckViewDto> toTrucksDto(Iterable<Truck> trucks);
}
