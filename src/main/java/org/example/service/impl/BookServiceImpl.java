package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

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

    @Override
    public List<BookEntity> getBook() {
        return (List<BookEntity>) repository.findAll();
    }

    @Override
    public boolean deleteBook(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }


}
