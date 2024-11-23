package com.souza.charles.model.entities;
/**
 * Course title: Complete Java - Object-Oriented Programming + Projects
 * Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 * Exercise done by: Charles Fernandes de Souza
 * Date: November 22, 2024
 */

import com.souza.charles.model.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private LocalDateTime momentOrder;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(LocalDateTime momentOrder, OrderStatus status, Client client) {
        this.momentOrder = momentOrder;
        this.status = status;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }
    /**
    public Double total() {
        double sum = 0.0;
        for (OrderItem item : items) {
            sum += item.subTotal();
        }
        return sum;
    }
    */
    public Double total() {
        return items.stream().mapToDouble(OrderItem::subTotal).sum();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nORDER SUMMARY:\n");
        stringBuilder.append("Order moment: ").append(momentOrder.format(dateTimeFormatter)).append("\n");
        stringBuilder.append("Order status: ").append(status).append("\n");
        stringBuilder.append("Client: ");
        stringBuilder.append(client).append("\n");
        stringBuilder.append("Order items:\n");
        for (OrderItem item : items) {
            stringBuilder.append(item).append("\n");
        }
        stringBuilder.append("Total price: ");
        stringBuilder.append(String.format("%.2f", total()));
        return stringBuilder.toString();
    }
}