package org.example.integration_test_big_bang_approach.controllers;

import org.example.integration_test_big_bang_approach.dtos.OrderRequest;
import org.example.integration_test_big_bang_approach.models.Order;
import org.example.integration_test_big_bang_approach.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public Order placeOrder(@RequestBody OrderRequest order) {
        return orderService.placeOrder(order.productId(), order.quantity());
    }
}
