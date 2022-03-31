package com.example.library_mangament.repo;

import com.example.library_mangament.modals.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Integer> {
}
