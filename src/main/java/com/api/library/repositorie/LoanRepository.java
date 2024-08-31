package com.api.library.repositorie;

import com.api.library.domain.loan.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.UUID;

public interface LoanRepository extends JpaRepository<Loan, UUID> {
    @Query("SELECT l FROM Loan l WHERE l.book.id = :id")
    public Page<Loan> findLoansInBookById (@Param("id") UUID id, Pageable pageable);
}
