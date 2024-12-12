package org.example.basic_integration_testing.services;


import org.example.basic_integration_testing.models.Order;
import org.example.basic_integration_testing.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
