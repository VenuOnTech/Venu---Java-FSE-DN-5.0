package com.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Book;
import com.library.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service){

        this.service=service;

    }

    @GetMapping

    public List<Book> getBooks(){

        return service.getAllBooks();

    }

    @PostMapping

    public Book addBook(@RequestBody Book book){

        return service.saveBook(book);

    }

}