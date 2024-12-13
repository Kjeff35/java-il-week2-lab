package org.example.integration_test_hybrid_approach.services.impl;

import org.example.integration_test_hybrid_approach.models.Product;
import org.example.integration_test_hybrid_approach.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }
}
