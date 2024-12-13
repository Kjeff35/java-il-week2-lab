package org.example.integration_test_hybrid_approach.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.integration_test_hybrid_approach.dtos.OrderRequest;
import org.example.integration_test_hybrid_approach.models.OrderItem;
import org.example.integration_test_hybrid_approach.models.Product;
import org.example.integration_test_hybrid_approach.repositories.OrderRepository;
import org.example.integration_test_hybrid_approach.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ProductRepository productRepository;
    private Product product;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
        product = new Product(1L, "product1", 12.9, 2);
        productRepository.save(product);
    }

    @Test
    public void testCreateOrder() throws Exception {
        OrderItem requestItem = new OrderItem(2, product);
        OrderRequest request = new OrderRequest(1L, List.of(requestItem));
        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.items[0].quantity").value(requestItem.getQuantity()))
                .andExpect(jsonPath("$.items[0].product.id").value(requestItem.getProduct().getId()))
                .andExpect(jsonPath("$.items[0].product.name").value(product.getName()))
                .andExpect(jsonPath("$.items[0].product.price").value(product.getPrice()));
    }
}