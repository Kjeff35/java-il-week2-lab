package org.example.integration_test_top_down_approach.repositories;

import org.example.integration_test_top_down_approach.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
