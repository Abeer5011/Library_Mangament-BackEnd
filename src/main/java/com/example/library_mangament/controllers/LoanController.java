package com.example.library_mangament.controllers;
import com.example.library_mangament.modals.Loan;
import com.example.library_mangament.modals.ResponseApi;
import com.example.library_mangament.services.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "*")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("loans")

    public ResponseEntity getAllLoans(){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getLoans());
    }

    @PostMapping("create-loan")
    public ResponseEntity addLoan(@RequestBody Loan loan){
        boolean isLoanAdd = loanService.addLoan(loan);
        if (!isLoanAdd){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseApi("book or user not present", "400"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseApi("loan is created", "201"));
    }
    @PostMapping("return-loan/{loanId}")

    public ResponseEntity returnLoan(@PathVariable Integer loanId){
        loanService.returnLoan(loanId);

        return ResponseEntity.status(201).body(new
                ResponseApi("Loan returned","201"));
    }
}
