package com.example.pizzaapp.services;

import com.example.pizzaapp.models.Order;
import com.example.pizzaapp.models.OrderState;
import com.example.pizzaapp.models.Pizza;
import com.example.pizzaapp.models.User;
import com.example.pizzaapp.repositories.OrderRepository;
import com.example.pizzaapp.repositories.PizzaRepository;
import com.example.pizzaapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final PizzaRepository pizzaRepository;

    public Order getOrderById(Long id) {
        try {
            Order order = orderRepository.findById(id).get();
            return order;
        } catch (Exception ex) {
            return new Order();
        }
    }

    public Long createPizzaOrder(Long userId, List<String> pizzaNameList) {
        try {
            User user = userRepository.findById(userId).get();
            List<Pizza> pizzaList = pizzaRepository.findAllByNameIsIn(pizzaNameList);

            Order order = new Order(user, pizzaList);
            var savedOrder = orderRepository.save(order);

            return savedOrder.getId();
        } catch (Exception ex) {
            return 0L;
        }
    }

    public boolean changeOrderState(Long id, OrderState orderState) {
        try {
            Order order = orderRepository.findById(id).get();
            order.setOrderState(orderState);
            orderRepository.save(order);

            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
