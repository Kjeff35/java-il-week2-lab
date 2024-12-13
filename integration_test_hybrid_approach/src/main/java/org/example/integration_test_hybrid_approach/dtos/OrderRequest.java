package org.example.integration_test_hybrid_approach.dtos;

import org.example.integration_test_hybrid_approach.models.OrderItem;

import java.util.List;

public record OrderRequest(Long customerId,
                           List<OrderItem> items) {

}
