package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository repository;

    ObjectMapper mapper;
    @Bean
    public void setup(){
        this.mapper=new ObjectMapper();
    }
    @Override
    public void addBook(Book book) {
        BookEntity entity = mapper.convertValue(book, BookEntity.class);
        repository.save(entity);
    }


}
