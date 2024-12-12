package org.example.integration_test_bottom_up_approach.services;

import org.example.integration_test_bottom_up_approach.models.Post;

import java.util.List;

public interface NewsFeedService {
    List<Post> getUserFeed(Integer userId);
}
