package com.example.testnova.controller;

import com.example.testnova.entities.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("books")
@RestController
public class BookController {


    List<Book> bookList = new ArrayList<>();
    @GetMapping("/getAllBook")
     public List<Book> getAllBooks(){
        return bookList;
     }

    @PostMapping("/addNewBook" )
    public ResponseEntity<Book> addNewBook(@RequestBody Book book) throws ServerException {
        bookList.add(book);
        if(bookList == null){
            throw new ServerException("Error when save book");
        }else {
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        }
    }

    @PutMapping("/updateBook/{id}" )
    public ResponseEntity<Book> updateBook(@PathVariable int id,@RequestBody Book book) throws ServerException {
        bookList.add(book);
        if(bookList == null){
            throw new ServerException("Error when save book");
        }else {
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        }
    }
}
