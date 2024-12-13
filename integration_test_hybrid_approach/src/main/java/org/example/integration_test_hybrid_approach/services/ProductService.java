package org.example.integration_test_hybrid_approach.services;

import org.example.integration_test_hybrid_approach.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);
}
