package com.velheor.internship.mappers;

import com.velheor.internship.dto.OrderViewDto;
import com.velheor.internship.models.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {

    public abstract OrderViewDto toOrderDto(Order order);

    public abstract Iterable<OrderViewDto> toOrdersViewDto(Iterable<Order> orders);

    public abstract Order toOrder(OrderViewDto orderViewDTO);
}
