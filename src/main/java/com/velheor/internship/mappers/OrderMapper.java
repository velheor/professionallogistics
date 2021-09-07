package com.velheor.internship.mappers;

import com.velheor.internship.dto.OrderViewDto;
import com.velheor.internship.dto.OrderViewWithUserDto;
import com.velheor.internship.models.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {

    public abstract OrderViewDto toOrderDto(Order order);

    public abstract Iterable<OrderViewDto> toOrdersViewDto(Iterable<Order> orders);

    public abstract List<OrderViewDto> toOrdersViewDto(List<Order> orders);

    public abstract Iterable<OrderViewWithUserDto> toOrdersViewWithUserDto(Iterable<Order> orders);

    public abstract Order toOrder(OrderViewDto orderViewDTO);
}
