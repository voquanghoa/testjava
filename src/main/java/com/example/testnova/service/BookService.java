package com.example.testnova.service;

import com.example.testnova.model.Book;
import com.example.testnova.request.BookRequest;

import java.util.List;
import java.util.UUID;

public interface BookService {

    List<Book> getBooks();

    Book getBook(UUID uuid);

    Book createBook(BookRequest req);

    void updateBook(UUID id, BookRequest req);

    void deleteBook(UUID uuid);

}
