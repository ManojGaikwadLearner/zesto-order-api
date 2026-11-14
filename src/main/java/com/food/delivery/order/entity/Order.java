package com.food.delivery.order.entity;

import com.food.delivery.order.dto.FoodItemDTO;
import com.food.delivery.order.dto.RestaurantDTO;
import com.food.delivery.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    private Integer orderId;
    private List<FoodItemDTO> foodItemsList;
    private RestaurantDTO restaurant;
    private UserDTO userDTO;
}
