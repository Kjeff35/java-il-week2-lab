package org.example.integration_test_hybrid_approach.services;

import org.example.integration_test_hybrid_approach.dtos.OrderRequest;
import org.example.integration_test_hybrid_approach.models.Order;

public interface OrderService {
    Order createOrder(OrderRequest request);
}
