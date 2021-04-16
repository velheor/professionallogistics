package com.velheor.internship.dto;

import lombok.Data;

@Data
public class RouteDTO extends BaseDTO {

    private AddressDTO addressTo;

    private AddressDTO addressFrom;
}
