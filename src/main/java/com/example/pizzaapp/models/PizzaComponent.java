package com.example.pizzaapp.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class PizzaComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private Pizza Pizza;

    @ManyToOne
    private Component Component;

    public PizzaComponent() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public com.example.pizzaapp.models.Pizza getPizza() {
        return Pizza;
    }

    public void setPizza(com.example.pizzaapp.models.Pizza pizza) {
        Pizza = pizza;
    }

    public com.example.pizzaapp.models.Component getComponent() {
        return Component;
    }

    public void setComponent(com.example.pizzaapp.models.Component component) {
        Component = component;
    }

    public PizzaComponent(Pizza pizza, Component component) {
        Pizza = pizza;
        Component = component;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PizzaComponent)) return false;
        PizzaComponent that = (PizzaComponent) o;
        return Objects.equals(Pizza, that.Pizza) && Objects.equals(Component, that.Component);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Pizza, Component);
    }

    @Override
    public String toString() {
        return "PizzaComponent{" +
                "Id=" + Id +
                ", Pizza=" + Pizza +
                ", Component=" + Component +
                '}';
    }
}
