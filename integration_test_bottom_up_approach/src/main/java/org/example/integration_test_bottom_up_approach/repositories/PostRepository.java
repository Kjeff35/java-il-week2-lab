package org.example.integration_test_bottom_up_approach.repositories;

import org.example.integration_test_bottom_up_approach.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByUserId(Integer userId);
}
