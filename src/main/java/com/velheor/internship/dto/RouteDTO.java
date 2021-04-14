package com.velheor.internship.dto;

import lombok.Data;

@Data
public class RouteDTO {

    private AddressDTO addressTo;

    private AddressDTO addressFrom;

    private OrderDTO order;
}
