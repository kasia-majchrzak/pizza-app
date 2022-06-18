package com.example.pizzaapp.models;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private Date OrderedOn;

    @ManyToOne
    private User User;

    @DecimalMin("0.00")
    private BigDecimal TotalPrice;

    @NotNull
    @NotEmpty
    private OrderState OrderState;

    public Order(User user, List<Pizza> pizzaList) {
        OrderedOn = new Date();
        User = user;
        TotalPrice = BigDecimal.ZERO;
        OrderState = OrderState.IN_PROGRESS;

        for (Pizza pizza: pizzaList) {
            TotalPrice = TotalPrice.add(pizza.getPrice());
        }
    }

    public Order() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getOrderedOn() {
        return OrderedOn;
    }

    public void setOrderedOn(Date orderedOn) {
        OrderedOn = orderedOn;
    }

    public com.example.pizzaapp.models.User getUser() {
        return User;
    }

    public void setUser(com.example.pizzaapp.models.User user) {
        User = user;
    }

    public BigDecimal getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        TotalPrice = totalPrice;
    }

    public OrderState getOrderState() {
        return OrderState;
    }

    public void setOrderState(OrderState orderState) {
        this.OrderState = orderState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(OrderedOn, order.OrderedOn) && Objects.equals(User, order.User) && Objects.equals(TotalPrice, order.TotalPrice) && OrderState == order.OrderState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, OrderedOn, User, TotalPrice, OrderState);
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + Id +
                ", OrderedOn=" + OrderedOn +
                ", User=" + User +
                ", TotalPrice=" + TotalPrice +
                ", orderState=" + OrderState +
                '}';
    }
}
