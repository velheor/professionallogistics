package com.velheor.internship.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserWithTruckDTO extends UserViewDTO {
    private TruckViewDTO truckViewDTO;
}
