package org.example.integration_test_top_down_approach.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.integration_test_top_down_approach.models.Book;
import org.example.integration_test_top_down_approach.services.BookServiceStub;
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
class BookingControllerStubTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    private BookServiceStub bookServiceStub;

    @BeforeEach
    public void setUp() {
        bookServiceStub.findAll().clear();
        bookServiceStub.addBook(new Book(1, "1984", "James Daniel", "Oldies"));
        bookServiceStub.addBook(new Book(2, "The lemon Suit Case", "Grace Lee", "Classic"));
    }

    @Test
    public void testFindAllBooks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/stub-books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testAddBook() throws Exception {
        Book book = new Book(3, "The Gods Are Not To Blame", "Ola", "Life Lessons");
        var result = mockMvc.perform(MockMvcRequestBuilders.post("/api/stub-books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(3))
                .andExpect(jsonPath("author").value("Ola"))
                .andReturn();

        String responseJson = result.getResponse().getContentAsString();
        System.out.println("Response JSON: " + responseJson);
    }

    @Test
    public void testFindBookById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/stub-books/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(2))
                .andExpect(jsonPath("author").value("Grace Lee"));
    }

    @Test
    public void testSearchBookByAuthor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/stub-books/search")
                        .param("author", "Grace Lee"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(2))
                .andExpect(jsonPath("author").value("Grace Lee"));
    }

    @Test
    public void testDeleteById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/stub-books/2"))
                .andExpect(status().isOk());
    }
}