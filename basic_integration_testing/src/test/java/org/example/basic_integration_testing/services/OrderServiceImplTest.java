package org.example.basic_integration_testing.services;

import org.example.basic_integration_testing.models.Order;
import org.example.basic_integration_testing.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-test.properties")
class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    public void setUp() {
        orderRepository.deleteAll();
    }

    @Test
    public void testSaveOrder() {
        Order order = new Order(100.0);

        Order savedOrder = orderService.saveOrder(order);

        assertNotNull(savedOrder);
        assertEquals(order.getId(), savedOrder.getId());
        assertEquals(order.getAmount(), savedOrder.getAmount());

        Order fetchedOrder = orderRepository.findById(order.getId()).orElse(null);

        assertNotNull(fetchedOrder);
        assertEquals(order.getId(), fetchedOrder.getId());
        assertEquals(order.getAmount(), fetchedOrder.getAmount());
    }

}