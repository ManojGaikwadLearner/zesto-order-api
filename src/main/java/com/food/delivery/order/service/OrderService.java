package com.food.delivery.order.service;

import com.food.delivery.order.dto.OrderDTO;
import com.food.delivery.order.dto.OrderDTOFromFE;
import com.food.delivery.order.dto.UserDTO;
import com.food.delivery.order.entity.Order;
import com.food.delivery.order.mapper.OrderMapper;
import com.food.delivery.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {
        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        UserDTO userDetails = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSaved = new Order(newOrderId, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDetails);
        orderRepo.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
        String applicationName = "user-service";
        String methodName = "user/fetchUserById";
        return restTemplate.getForObject("http://"+ applicationName +"/" + methodName + "/" + userId, UserDTO.class);
    }
}
