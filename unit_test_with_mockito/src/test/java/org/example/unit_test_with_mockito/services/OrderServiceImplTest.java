package org.example.unit_test_with_mockito.services;

import org.example.unit_test_with_mockito.models.Order;
import org.example.unit_test_with_mockito.repositories.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    public void testSaveOrder() {
        Order order = new Order("123", 100.0);

        when(orderRepository.save(order)).thenReturn(true);

        boolean result = orderService.saveOrder(order);

        assertTrue(result);
        verify(orderRepository).save(order);
    }

    @Test
    public void testSaveOrderFail() {
        Order order = new Order("124", 50.0);

        when(orderRepository.save(order)).thenReturn(false);

        boolean result = orderService.saveOrder(order);

        assertFalse(result);
        verify(orderRepository).save(order);
    }
}