package com.velheor.internship.mappers;

import com.velheor.internship.dto.TruckViewDTO;
import com.velheor.internship.models.Truck;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class TruckMapper {

    public abstract TruckViewDTO truckToTruckDto(Truck truck);

    public abstract Truck truckDtoToTruck(TruckViewDTO truckViewDTO);

    public abstract Iterable<TruckViewDTO> trucksToTrucksDto(Iterable<Truck> trucks);
}
