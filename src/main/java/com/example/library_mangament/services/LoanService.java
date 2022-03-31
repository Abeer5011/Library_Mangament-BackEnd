package com.example.library_mangament.services;

import com.example.library_mangament.modals.Book;
import com.example.library_mangament.modals.Loan;
import com.example.library_mangament.modals.User;
import com.example.library_mangament.repo.BookRepo;
import com.example.library_mangament.repo.LoanRepo;
import com.example.library_mangament.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanService {


    private final LoanRepo loanRepo;
    private final BookRepo bookRepo;
    private final UserRepo userRepo;





    public List<Loan> getLoans() {
        return loanRepo.findAll();
    }

    public boolean addLoan(Loan loan) {
        Optional<Book> book = bookRepo.findById(loan.getBook_id());
        if(book.isEmpty()){
            return false;
        }

        Optional<User> user = userRepo.findById(loan.getUser_id());
        if(user.isEmpty()){
            return false;
        }
        loanRepo.save(loan);
        return true;
    }

    public void returnLoan(Integer loanId) {
        Loan loan = loanRepo.getById(loanId);
        loan.setReturned(true);
        loanRepo.save(loan);
    }
}
