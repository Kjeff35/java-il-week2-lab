package org.example.unit_test_with_mockito.models;

import lombok.Data;

@Data
public class Order {
    private String orderId;
    private double amount;

    public Order(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

}

