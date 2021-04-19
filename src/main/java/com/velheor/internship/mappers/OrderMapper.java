package com.velheor.internship.mappers;

import com.velheor.internship.dto.OrderViewDTO;
import com.velheor.internship.models.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderViewDTO orderToOrderDto(Order order);

    Iterable<OrderViewDTO> ordersToOrdersDto(Iterable<Order> orders);

    Order orderDtoToOrder(OrderViewDTO orderViewDTO);
}
