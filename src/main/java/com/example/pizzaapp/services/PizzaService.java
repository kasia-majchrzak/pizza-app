package com.example.pizzaapp.services;

import com.example.pizzaapp.models.Pizza;
import com.example.pizzaapp.models.PizzaComponent;
import com.example.pizzaapp.repositories.PizzaComponentRepository;
import com.example.pizzaapp.repositories.PizzaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaComponentRepository pizzaComponentRepository;

    public List<Pizza> findAll() {
        List<Pizza> pizzas = pizzaRepository.findAll();
        for (Pizza pizza: pizzas) {
            List<PizzaComponent> pizzaComponents = pizzaComponentRepository.findAllByPizza(pizza);
            pizza.setComponents(pizzaComponents);
        }

        return pizzas;
    }
}
