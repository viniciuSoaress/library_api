package com.api.library.domain.loan;

import com.api.library.domain.book.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "loan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name_user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data = new Date();

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
