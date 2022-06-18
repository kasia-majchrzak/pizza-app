package com.example.pizzaapp.repositories;

import com.example.pizzaapp.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findAll();
    List<Pizza> findAllByNameIsIn(List<String> name);
}
