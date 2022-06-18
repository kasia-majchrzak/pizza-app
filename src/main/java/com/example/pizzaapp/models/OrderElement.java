package com.example.pizzaapp.models;

import javax.persistence.*;

@Entity
public class OrderElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private Order Order;

    @ManyToOne
    private Pizza Pizza;


}
