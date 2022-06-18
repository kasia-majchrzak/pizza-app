package com.example.pizzaapp.repositories;

import com.example.pizzaapp.models.Pizza;
import com.example.pizzaapp.models.PizzaComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaComponentRepository extends JpaRepository<PizzaComponent, Long> {
    List<PizzaComponent> findAllByPizza(Pizza pizza);
}
