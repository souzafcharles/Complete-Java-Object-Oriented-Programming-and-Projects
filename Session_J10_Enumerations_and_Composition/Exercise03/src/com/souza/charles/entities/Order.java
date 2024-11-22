package com.souza.charles.entities;

import com.souza.charles.entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime momentOrder;
    private OrderStatus status;

    List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(LocalDateTime momentOrder, OrderStatus status) {
        this.momentOrder = momentOrder;
        this.status = status;
    }

    public LocalDateTime getMomentOrder() {
        return momentOrder;
    }

    public void setMomentOrder(LocalDateTime momentOrder) {
        this.momentOrder = momentOrder;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }
    
    public Double total(){
        double sum = 0.0;
        for (OrderItem item : items) {
            sum = item.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "momentOrder=" + momentOrder +
                ", status=" + status +
                ", items=" + items +
                '}';
    }
}