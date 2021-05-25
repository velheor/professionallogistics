package com.velheor.internship.mappers;

import com.velheor.internship.dto.OrderViewDTO;
import com.velheor.internship.models.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {

    public abstract OrderViewDTO toOrderDto(Order order);

    public abstract Iterable<OrderViewDTO> toOrdersViewDto(Iterable<Order> orders);

    public abstract Order toOrder(OrderViewDTO orderViewDTO);
}
