package com.velheor.internship.service.api;

import com.velheor.internship.models.Order;
import java.util.UUID;

public interface IOrderService extends Crud<Order> {

    Order findById(UUID id);
}
