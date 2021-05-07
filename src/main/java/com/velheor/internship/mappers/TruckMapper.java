package com.velheor.internship.mappers;

import com.velheor.internship.dto.TruckViewDTO;
import com.velheor.internship.dto.UserViewDTO;
import com.velheor.internship.models.Truck;
import com.velheor.internship.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TruckMapper {

    TruckViewDTO truckToTruckDto(Truck truck);

    Truck truckDtoToTruck(TruckViewDTO truckViewDTO);

    Iterable<TruckViewDTO> trucksToTrucksDto(Iterable<Truck> trucks);
}
