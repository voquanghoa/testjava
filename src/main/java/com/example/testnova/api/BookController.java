package com.example.testnova.api;

import com.example.testnova.model.Book;
import com.example.testnova.request.BookRequest;
import com.example.testnova.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBooks(@PathVariable("id") UUID id){
        return bookService.getBook(id);
    }

    @PostMapping
    public Book createBook(@RequestBody BookRequest req){
        return bookService.createBook(req);
    }

    @PutMapping("/{id}")
    public void updateBook(
            @PathVariable("id") UUID id,
            @RequestBody @Validated BookRequest req){
        bookService.updateBook(id, req);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") UUID id){
        bookService.deleteBook(id);
    }

}
