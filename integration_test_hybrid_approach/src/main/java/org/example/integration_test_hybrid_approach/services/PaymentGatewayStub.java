package org.example.integration_test_hybrid_approach.services;

import org.example.integration_test_hybrid_approach.models.Order;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayStub {
    public boolean processPayment(Order order) {
        return true;
    }
}
