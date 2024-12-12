package org.example.integration_test_bottom_up_approach.services.impl;

import org.example.integration_test_bottom_up_approach.models.Post;
import org.example.integration_test_bottom_up_approach.models.User;
import org.example.integration_test_bottom_up_approach.repositories.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NewsFeedServiceImplTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private NewsFeedServiceImpl newsFeedService;

    private List<Post> posts;

    @BeforeEach
    public void setUp() {
        User user = new User(1, "test1", "test@gmail.com");

        Post post1 = new Post(1, "Hello World!", LocalDateTime.now(), user);
        Post post2 = new Post(2, "Tired", LocalDateTime.now(), user);

        posts = Arrays.asList(post1, post2);
    }

    @Test
    public void testGetUserFeed() {
        when(postRepository.findAllByUserId(1)).thenReturn(posts);

        List<Post> feed = newsFeedService.getUserFeed(1);

        assertEquals(2, feed.size());
        assertEquals("Hello World!", feed.getFirst().getContent());
    }
}