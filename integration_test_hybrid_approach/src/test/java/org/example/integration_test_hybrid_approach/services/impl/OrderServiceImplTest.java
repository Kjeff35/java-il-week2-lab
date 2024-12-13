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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private OrderItemRepository orderItemRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    void testCreateOrder() {
        // Arrange
        Long customerId = 1L;
        Long productId = 1L;
        int quantity = 2;

        Customer customer = new Customer();
        customer.setId(customerId);

        Product product = new Product();
        product.setId(productId);

        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(quantity);
        orderItem.setProduct(product);

        Order order = new Order();
        order.setCustomer(customer);
        order.setItems(List.of(orderItem));

        OrderItem requestItem = new OrderItem(quantity, product);
        OrderRequest request = new OrderRequest(customerId, List.of(requestItem));

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(orderItemRepository.save(any(OrderItem.class))).thenReturn(orderItem);
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order createdOrder = orderService.createOrder(request);

        assertEquals(customer, createdOrder.getCustomer());
        assertEquals(1, createdOrder.getItems().size());
        assertEquals(quantity, createdOrder.getItems().get(0).getQuantity());
        verify(customerRepository, times(1)).findById(customerId);
        verify(productRepository, times(1)).findById(productId);
        verify(orderItemRepository, times(1)).save(any(OrderItem.class));
        verify(orderRepository, times(1)).save(any(Order.class));
    }
}