package org.example.integration_test_top_down_approach.services;

import org.example.integration_test_top_down_approach.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceStubTest {

    @Autowired
    private BookServiceStub bookServiceStub;

    @BeforeEach
    public void setUp() {
        bookServiceStub.findAll().clear();
        bookServiceStub.addBook(new Book(1, "1984", "James Daniel", "Oldies"));
        bookServiceStub.addBook(new Book(2, "The lemon Suit Case", "Grace Lee", "Classic"));
    }

    @Test
    public void testFindAll() {
        assertEquals(2, bookServiceStub.findAll().size());
    }

    @Test
    public void testAddBook() {
        bookServiceStub.addBook(new Book(3, "Hey There!", "Mavis Beacon", "Nat"));
        assertEquals(3, bookServiceStub.findAll().size());
    }

    @Test
    public void testDeleteBook() {
        bookServiceStub.deleteBook(1);
        assertEquals(1, bookServiceStub.findAll().size());
    }

    @Test
    public void testSearchBook() {
        Optional<Book> book = bookServiceStub.getSearchByAuthor("James Daniel");
        if (book.isPresent()) {
            assertEquals(1, book.get().getId());
            assertEquals("1984", book.get().getTitle());
        }
    }


}