package org.example.integration_test_top_down_approach.services;

import org.example.integration_test_top_down_approach.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceStub {
    private final List<Book> books = new ArrayList<>();

    public List<Book> findAll() {
        return books;
    }

    public Optional<Book> getBookById(Integer id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public boolean deleteBook(Integer id) {
        return books.removeIf(book -> book.getId().equals(id));
    }

    public Optional<Book> getSearchByAuthor(String author) {
        return books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).findFirst();
    }
}
