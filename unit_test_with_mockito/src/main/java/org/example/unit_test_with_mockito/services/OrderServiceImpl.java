package org.example.unit_test_with_mockito.services;


import lombok.RequiredArgsConstructor;
import org.example.unit_test_with_mockito.models.Order;
import org.example.unit_test_with_mockito.repositories.OrderRepository;

@RequiredArgsConstructor
public class OrderServiceImpl {
    private final OrderRepository orderRepository;

    public boolean saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
