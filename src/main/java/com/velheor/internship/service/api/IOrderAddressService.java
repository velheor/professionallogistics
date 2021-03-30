package com.velheor.internship.service.api;

import com.velheor.internship.models.OrderAddress;
import java.util.UUID;

public interface IOrderAddressService extends Crud<OrderAddress> {

    OrderAddress findById(UUID id);
}
