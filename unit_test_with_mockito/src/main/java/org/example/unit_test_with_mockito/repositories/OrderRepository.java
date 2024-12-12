package org.example.unit_test_with_mockito.repositories;

import org.example.unit_test_with_mockito.models.Order;

public interface OrderRepository {
    boolean save(Order order);
}
