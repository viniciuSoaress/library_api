package com.api.library.service;


import com.api.library.domain.author.Author;
import com.api.library.domain.book.Book;
import com.api.library.domain.book.BookRequestDTO;
import com.api.library.repositorie.AuthorRepository;
import com.api.library.repositorie.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Book create(BookRequestDTO data, UUID id){
        Author author = this.authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Author not exist."));

        Book book = new Book();
        book.setIs_available(false);
        book.setDate(data.date());
        book.setIsbn(data.isbn());
        book.setTitle(data.title());
        book.setDescription(data.description());
        book.setNumber_page(data.number_page());
        book.setAuthor(author);

        return this.bookRepository.save(book);
    }

    public Book read(UUID id){
        return this.bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("book not exist"));
    }

    public Book update (BookRequestDTO data, UUID id){
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("book not exist"));

        book.setDate(data.date());
        book.setIsbn(data.isbn());
        book.setTitle(data.title());
        book.setDescription(data.description());
        book.setNumber_page(data.number_page());



        return this.bookRepository.save(book);
    }

    public void delete (UUID id){
        this.bookRepository.deleteById(id);
    }
}
