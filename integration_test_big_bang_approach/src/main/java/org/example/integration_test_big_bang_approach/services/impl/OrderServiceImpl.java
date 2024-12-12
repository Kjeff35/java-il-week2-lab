package org.example.integration_test_big_bang_approach.services.impl;

import org.example.integration_test_big_bang_approach.models.Order;
import org.example.integration_test_big_bang_approach.models.Product;
import org.example.integration_test_big_bang_approach.repositories.OrderRepository;
import org.example.integration_test_big_bang_approach.repositories.ProductRepository;
import org.example.integration_test_big_bang_approach.services.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order placeOrder(Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElse(null);
        Order order = new Order(product, quantity);
        return orderRepository.save(order);
    }
}
