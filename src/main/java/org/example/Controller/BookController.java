package org.example.Controller;

import org.example.dto.BookDto;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService service;

    @PostMapping("")
    public void addBook(@RequestBody BookDto book){
        service.addBook(book);
    }
}
