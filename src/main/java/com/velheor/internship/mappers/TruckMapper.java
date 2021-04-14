package com.velheor.internship.mappers;

import com.velheor.internship.dto.TruckDTO;
import com.velheor.internship.models.Truck;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TruckMapper {

    TruckDTO truckToTruckDto(Truck truck);

    Truck truckDtoToTruck(TruckDTO truckDTO);
}
