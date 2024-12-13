package org.example.integration_test_hybrid_approach.repositories;

import org.example.integration_test_hybrid_approach.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
