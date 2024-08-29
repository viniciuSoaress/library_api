package com.api.library.service;

import com.api.library.domain.author.Author;
import com.api.library.domain.author.AuthorRequestDTO;
import com.api.library.domain.book.Book;
import com.api.library.repositorie.AuthorRepository;
import com.api.library.repositorie.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public Author create(AuthorRequestDTO data){
        Author author = new Author();
        author.setName(data.name());
        author.setNationality(data.nationality());

        return this.authorRepository.save(author);
    }

    public Author update(AuthorRequestDTO data, UUID id){
        Author author = this.authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Author not exist"));

        author.setName(data.name());
        author.setNationality(data.nationality());

        return this.authorRepository.save(author);
    }

    public Author searchAuthor(UUID id){
        return this.authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Author not exist"));
    }

    public void delete (UUID id){
        this.authorRepository.deleteById(id);
    }

    public List<Book> getBooksWithAuthor(UUID id, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> pageBooks = this.bookRepository.findBookWithAuthor(id, pageable);

        return pageBooks.map(book -> new Book(book.getId(), book.getTitle(), book.getDescription(), book.getDate(), book.getNumber_page(),book.is_available() ,book.getIsbn(), book.getAuthor()))
                .stream().toList();
    }

}
