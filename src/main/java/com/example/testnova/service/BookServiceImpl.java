package com.example.testnova.service;

import com.example.testnova.model.Book;
import com.example.testnova.request.BookRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> getBooks() {
        return this.books;
    }

    @Override
    public Book getBook(UUID uuid) {
        return this.books.stream().filter(b -> b.getUuid().equals(uuid)).findFirst().orElse(null);
    }

    @Override
    public Book createBook(BookRequest req) {

        var book = new Book();
        book.setUuid(UUID.randomUUID());
        book.setName(req.getName());

        this.books.add(book);
        return book;
    }

    @Override
    public void updateBook(UUID id, BookRequest req) {
        var bookOpt = this.books.stream().filter(b -> b.getUuid().equals(id)).findAny();
        if(bookOpt.isPresent()){
            var book = bookOpt.get();
            this.books.remove(book);
            var boor = bookOpt.get();
            boor.setName(req.getName());
            this.books.add(book);
        }
    }

    @Override
    public void deleteBook(UUID uuid) {
        var bookOpt = this.books.stream().filter(b -> b.getUuid().equals(uuid)).findAny();
        if(bookOpt.isPresent()){
            books.remove(bookOpt.get());
        }
    }
}
