package org.example.service;

import org.springframework.stereotype.Service;
import org.example.dto.BookDto;



public interface BookService {

    void addBook(BookDto bookDto);
}
