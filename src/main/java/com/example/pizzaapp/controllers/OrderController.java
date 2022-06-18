package com.example.pizzaapp.controllers;

import com.example.pizzaapp.models.Order;
import com.example.pizzaapp.models.OrderState;
import com.example.pizzaapp.models.Pizza;
import com.example.pizzaapp.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/get-order")
    public Order getOrder(Long id) {
        var result = orderService.getOrderById(id);
        return result;
    }

    @PutMapping("/update-order-state")
    public boolean UpdateOrderState(Long id, OrderState orderState) {
        var result = orderService.changeOrderState(id, orderState);
        return result;
    }

    @PostMapping("/create-order")
    public Long CreateOrder(Long userId, String pizzaNames) {
        List<String> pizzaNameList = Arrays.asList(pizzaNames.split(","));
        var result = orderService.createPizzaOrder(userId, pizzaNameList);
        return result;
    }
}
