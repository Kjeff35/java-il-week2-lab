package org.example.integration_test_big_bang_approach.repositories;

import org.example.integration_test_big_bang_approach.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
