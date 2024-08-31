package com.api.library.service;

import com.api.library.domain.book.Book;
import com.api.library.domain.loan.Loan;
import com.api.library.domain.loan.LoanRequestDTO;
import com.api.library.repositorie.BookRepository;
import com.api.library.repositorie.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    public String makeALoan (UUID id, LoanRequestDTO data){
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("book not exist."));

        Loan loan = new Loan();

        if(book.getIs_available().equals(true)){
            return "O livro "+ book.getTitle() + " não esta disponivel.";
        } else{
            book.setIs_available(true);
            loan.setName_user(data.name_user());
            loan.setBook(book);

            this.bookRepository.save(book);
            this.loanRepository.save(loan);

            return book.getTitle() + "pego.";
        }

    }

    public String returnLoan(UUID id){
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("book not exist."));

        book.setIs_available(false);
        this.bookRepository.save(book);

        return "devolução feita.";
    }

    public List<Loan> findLoansInBookById(UUID id, int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<Loan> loans = this.loanRepository.findLoansInBookById(id, pageable);

        return loans.map(loan -> new Loan(
                loan.getId(),
                loan.getName_user(),
                loan.getData(),
                loan.getBook()
        )).stream().toList();
    }
}
