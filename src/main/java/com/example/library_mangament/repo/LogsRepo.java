package com.example.library_mangament.repo;

import com.example.library_mangament.modals.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepo extends JpaRepository<Logs, Integer> {
}
