package org.example.integration_test_bottom_up_approach.services.impl;

import org.example.integration_test_bottom_up_approach.models.User;
import org.example.integration_test_bottom_up_approach.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User(1, "testuser", "testuser@gmail.com");
    }

    @Test
    public void testFindByUsername_UserFound() {
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));

        User foundUser = userService.findByUsername("testuser");

        assertEquals(user, foundUser);
    }

    @Test
    public void testFindByUsername_UserNotFound() {
        when(userRepository.findByUsername("nonexistent")).thenReturn(Optional.empty());

        User foundUser = userService.findByUsername("nonexistent");

        assertNull(foundUser);
    }

    @Test
    public void testRegisterUser() {
        when(userRepository.save(user)).thenReturn(user);

        User registeredUser = userService.registerUser(user);

        assertEquals(user, registeredUser);
    }
}