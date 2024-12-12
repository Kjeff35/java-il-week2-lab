package org.example.integration_test_top_down_approach.services;

import org.example.integration_test_top_down_approach.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceStub {
    private final List<User> users = new ArrayList<>();

    public UserServiceStub() {
        users.add(new User(1, "John", "Doe"));
        users.add(new User(2, "Matthew", "Daniels"));
    }

    public List<User> findAll() {
        return users;
    }

    public Optional<User> getBookById(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public User addBook(User user) {
        users.add(user);
        return user;
    }

    public boolean deleteBook(Integer id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}
