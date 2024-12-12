package org.example.integration_test_big_bang_approach.repositories;

import org.example.integration_test_big_bang_approach.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
