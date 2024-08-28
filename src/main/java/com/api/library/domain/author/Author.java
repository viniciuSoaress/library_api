package com.api.library.domain.author;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "author")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String nationality;
}
