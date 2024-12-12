package org.example.integration_test_bottom_up_approach.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.integration_test_bottom_up_approach.models.User;
import org.example.integration_test_bottom_up_approach.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
        userRepository.save(new User(1, "John", "john.doe@gmail.com"));
        userRepository.save(new User(2, "Mathew", "mathew.doe@gmail.com"));
    }

    @Test
    public void testFindUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/{username}", "John"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("email").value("john.doe@gmail.com"));
    }

    @Test
    public void testCreateUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new User(3, "Denis", "denis.doe@gmail.com"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(3))
                .andExpect(jsonPath("email").value("denis.doe@gmail.com"));
    }
}