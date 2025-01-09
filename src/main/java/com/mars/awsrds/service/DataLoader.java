package com.mars.awsrds.service;
import com.mars.awsrds.entity.Book;
import com.mars.awsrds.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DataLoader {

   // @Bean
    public CommandLineRunner loadData(BookRepository bookRepository) {
//
        return null;
    }
}
