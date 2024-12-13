package org.example.integration_test_hybrid_approach.controllers;

import org.example.integration_test_hybrid_approach.dtos.OrderRequest;
import org.example.integration_test_hybrid_approach.models.Order;
import org.example.integration_test_hybrid_approach.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

}
