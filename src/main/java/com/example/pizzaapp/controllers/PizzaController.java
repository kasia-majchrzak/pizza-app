package com.example.pizzaapp.controllers;

import com.example.pizzaapp.models.Pizza;
import com.example.pizzaapp.services.PizzaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PizzaController {
    private final PizzaService pizzaService;

    @GetMapping("/get-all-pizzas")
    public List<Pizza> getAllPizzas() {
        var result = pizzaService.findAll();
        return result;
    }
}
