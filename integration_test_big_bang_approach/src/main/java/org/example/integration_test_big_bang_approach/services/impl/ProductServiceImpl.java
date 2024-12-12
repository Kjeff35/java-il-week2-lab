package org.example.integration_test_big_bang_approach.services.impl;

import org.example.integration_test_big_bang_approach.models.Product;
import org.example.integration_test_big_bang_approach.repositories.ProductRepository;
import org.example.integration_test_big_bang_approach.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
