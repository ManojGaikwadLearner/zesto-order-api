package com.food.delivery.order.mapper;

import com.food.delivery.order.dto.FoodItemDTO;
import com.food.delivery.order.dto.OrderDTO;
import com.food.delivery.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDTOToOrder(OrderDTO orderDTO);
    OrderDTO mapOrderToOrderDTO(Order order);
}
