package com.api.library.repositorie;

import com.api.library.domain.author.Author;
import com.api.library.domain.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
