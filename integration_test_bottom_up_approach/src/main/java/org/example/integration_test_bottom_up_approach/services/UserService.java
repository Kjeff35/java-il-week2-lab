package org.example.integration_test_bottom_up_approach.services;

import org.example.integration_test_bottom_up_approach.models.User;

public interface UserService {
    User findByUsername(String username);

    User registerUser(User user);
}
