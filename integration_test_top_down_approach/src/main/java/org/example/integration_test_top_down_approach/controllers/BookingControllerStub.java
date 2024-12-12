package org.example.integration_test_top_down_approach.controllers;

import org.example.integration_test_top_down_approach.models.Book;
import org.example.integration_test_top_down_approach.services.BookServiceStub;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stub-books")
public class BookingControllerStub {
    private final BookServiceStub bookServiceStub;
    
    public BookingControllerStub(final BookServiceStub bookServiceStub) {
        this.bookServiceStub = bookServiceStub;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookServiceStub.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        return bookServiceStub.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<Book> searchBookByAuthor(@RequestParam String author) {
        return bookServiceStub.getSearchByAuthor(author)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookServiceStub.addBook(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        if (bookServiceStub.deleteBook(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
