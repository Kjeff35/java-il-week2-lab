package org.example.integration_test_big_bang_approach.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.integration_test_big_bang_approach.dtos.OrderRequest;
import org.example.integration_test_big_bang_approach.models.Product;
import org.example.integration_test_big_bang_approach.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class OrderIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ProductRepository productRepository;

    private OrderRequest orderRequest;


    @BeforeEach
    public void setUp() {
        productRepository.save(new Product(1L, "Product1", 100.0));
        orderRequest = new OrderRequest(1L, 4);
    }

    @Test
    public void testPlaceOrder() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quantity").value(4));
    }
}
