package com.food.delivery.order.controller;

import com.food.delivery.order.dto.OrderDTO;
import com.food.delivery.order.dto.OrderDTOFromFE;
import com.food.delivery.order.entity.Order;
import com.food.delivery.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails) {
        OrderDTO orderSavedInDb = orderService.saveOrderInDb(orderDetails);
        return new ResponseEntity<>(orderSavedInDb , HttpStatus.CREATED);
    }
}
