package org.example.integration_test_hybrid_approach.repositories;

import org.example.integration_test_hybrid_approach.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
