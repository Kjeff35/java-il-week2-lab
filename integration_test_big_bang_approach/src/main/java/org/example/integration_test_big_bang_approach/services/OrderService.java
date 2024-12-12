package org.example.integration_test_big_bang_approach.services;

import org.example.integration_test_big_bang_approach.models.Order;

public interface OrderService {
    Order placeOrder(Long productId, int quantity);
}
