package org.example.Controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    final BookService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
        service.addBook(book);
    }
    @GetMapping("/get")
    @ResponseStatus(HttpStatus.FOUND)
    public List<BookEntity> getBook(){
        return service.getBook();
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public String deleteBook(@PathVariable Long id){
        boolean isDeleted=service.deleteBook(id);
        return isDeleted ?"Deleted":"not Deleted";
    }
}
