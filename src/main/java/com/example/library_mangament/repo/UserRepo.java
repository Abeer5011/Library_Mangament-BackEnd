package com.example.library_mangament.repo;

import com.example.library_mangament.modals.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);
}

