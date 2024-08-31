package com.api.library.controller;


import com.api.library.domain.book.Book;
import com.api.library.domain.book.BookRequestDTO;
import com.api.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/{id}")
    public ResponseEntity<Book> create(
            @RequestBody BookRequestDTO data,
            @PathVariable UUID id){
        return ResponseEntity.ok(this.bookService.create(data, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> read (
            @PathVariable UUID id){
        return ResponseEntity.ok(this.bookService.read(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Book> update(
            @RequestBody BookRequestDTO data,
            @PathVariable UUID id){
        return ResponseEntity.ok(this.bookService.update(data, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable UUID id){
        this.bookService.delete(id);
        return ResponseEntity.ok().build();
    }
}
