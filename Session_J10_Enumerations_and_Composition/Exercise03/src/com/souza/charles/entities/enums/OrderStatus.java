package com.souza.charles.entities.enums;

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
