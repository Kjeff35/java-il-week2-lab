package org.example.integration_test_bottom_up_approach.services.impl;

import org.example.integration_test_bottom_up_approach.models.User;
import org.example.integration_test_bottom_up_approach.repositories.UserRepository;
import org.example.integration_test_bottom_up_approach.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
