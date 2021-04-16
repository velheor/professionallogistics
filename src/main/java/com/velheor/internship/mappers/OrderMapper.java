package com.velheor.internship.mappers;

import com.velheor.internship.dto.OrderDTO;
import com.velheor.internship.models.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO orderToOrderDto(Order order);

    Iterable<OrderDTO> ordersToOrdersDto(Iterable<Order> orders);

    Order orderDtoToOrder(OrderDTO orderDTO);
}
