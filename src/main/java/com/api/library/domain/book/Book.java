package com.api.library.domain.book;

import com.api.library.domain.author.Author;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;
    private String date;
    private int number_page;
    private boolean is_available;

    @Column(unique = true)
    private String isbn;


    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
