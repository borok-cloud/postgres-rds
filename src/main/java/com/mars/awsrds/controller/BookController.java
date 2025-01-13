package com.mars.awsrds.controller;
import com.mars.awsrds.repository.BookRepository;
import com.mars.awsrds.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
//        return List.of(new Book("Effective Java", "Joshua Bloch", 45.99),
//                new Book("Spring in Action", "Craig Walls", 39.99),
//                new Book("Clean Code", "Robert C. Martin", 49.99));
    }

    //Add a health check endpoint
    @GetMapping("/health")
    public String healthCheck() {
        return "I'm Up version 2!";
    }
}
