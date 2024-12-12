package org.example.integration_test_bottom_up_approach.services.impl;

import org.example.integration_test_bottom_up_approach.models.Post;
import org.example.integration_test_bottom_up_approach.repositories.PostRepository;
import org.example.integration_test_bottom_up_approach.services.NewsFeedService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsFeedServiceImpl implements NewsFeedService {
    private final PostRepository postRepository;

    public NewsFeedServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getUserFeed(Integer userId) {
        return postRepository.findAllByUserId(userId);
    }
}
