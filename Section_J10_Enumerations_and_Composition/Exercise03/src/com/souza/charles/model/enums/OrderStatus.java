package com.souza.charles.model.enums;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 22, 2024
 */
public enum OrderStatus {
    PENDING_PAYMENT(0),
    PROCESSING(1),
    SHIPPED(2),
    DELIVERED(3);

    private final int valueOrderStatus;

    OrderStatus(int value) {
        this.valueOrderStatus = value;
    }

    public int getValueOrderStatus() {
        return valueOrderStatus;
    }
}