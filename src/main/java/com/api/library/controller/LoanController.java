package com.api.library.controller;

import com.api.library.domain.loan.Loan;
import com.api.library.domain.loan.LoanRequestDTO;
import com.api.library.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/make/{id}")
    public ResponseEntity<String> makeLoan(
            @RequestBody LoanRequestDTO data,
            @PathVariable UUID id
            ){
        return ResponseEntity.ok(this.loanService.makeALoan(id, data));
    }

    @PostMapping("/return/{id}")
    public ResponseEntity<String> returnLoan (
            @PathVariable UUID id
    ){

        return ResponseEntity.ok(this.loanService.returnLoan(id));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<Loan>> getAllLoans (
            @PathVariable UUID id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        return  ResponseEntity.ok(this.loanService.findLoansInBookById(id,page,size));
    }
}
