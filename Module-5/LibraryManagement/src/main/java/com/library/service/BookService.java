package com.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.repository.BookRepository;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(){}

    public BookService(BookRepository repository){

        this.bookRepository=repository;

    }

    public void setBookRepository(BookRepository repository){

        this.bookRepository=repository;

    }

    public List<Book> getAllBooks(){

        return bookRepository.findAll();

    }

    public Book saveBook(Book book){

        return bookRepository.save(book);

    }

}