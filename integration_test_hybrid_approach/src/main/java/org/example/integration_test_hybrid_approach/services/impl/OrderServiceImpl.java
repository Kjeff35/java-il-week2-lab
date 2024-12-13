package org.example.integration_test_hybrid_approach.services.impl;

import org.example.integration_test_hybrid_approach.dtos.OrderRequest;
import org.example.integration_test_hybrid_approach.models.Customer;
import org.example.integration_test_hybrid_approach.models.Order;
import org.example.integration_test_hybrid_approach.models.OrderItem;
import org.example.integration_test_hybrid_approach.models.Product;
import org.example.integration_test_hybrid_approach.repositories.CustomerRepository;
import org.example.integration_test_hybrid_approach.repositories.OrderItemRepository;
import org.example.integration_test_hybrid_approach.repositories.OrderRepository;
import org.example.integration_test_hybrid_approach.repositories.ProductRepository;
import org.example.integration_test_hybrid_approach.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Order createOrder(OrderRequest request) {
        Customer customer = customerRepository.findById(request.customerId()).orElse(null);

        List<OrderItem> orderItems = request.items().stream()
                .map(requestItem -> {
                    Product product = productRepository.findById(requestItem.getProduct().getId())
                            .orElse(null);
                    OrderItem orderItem = new OrderItem(requestItem.getQuantity(), product);
                    return orderItemRepository.save(orderItem);
                })
                .toList();

        Order order = new Order(customer, orderItems);
        return orderRepository.save(order);
    }
}
