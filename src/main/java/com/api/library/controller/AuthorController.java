package com.api.library.controller;


import com.api.library.domain.author.Author;
import com.api.library.domain.author.AuthorRequestDTO;
import com.api.library.domain.book.Book;
import com.api.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> create(
            @RequestBody @Validated AuthorRequestDTO data){
        return ResponseEntity.ok(this.authorService.create(data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> read (
            @PathVariable UUID id){
        return ResponseEntity.ok(this.authorService.read(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Author> upadte(
            @PathVariable UUID id,
            @RequestBody @Validated AuthorRequestDTO data){
        return ResponseEntity.ok(this.authorService.update(data, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable UUID id){
        this.authorService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<List<Book>> getAllBooks(
            @PathVariable UUID id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size){
        return ResponseEntity.ok(this.authorService.getBooksWithAuthor(id, page,size));
    }
}
