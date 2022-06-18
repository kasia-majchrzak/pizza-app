package com.example.pizzaapp.repositories;

import com.example.pizzaapp.models.Order;
import com.example.pizzaapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long id);
    List<Order> findAllByUser(User user);
    void deleteAllByUser(User user);
}
