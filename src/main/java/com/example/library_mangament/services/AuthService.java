package com.example.library_mangament.services;

import com.example.library_mangament.modals.User;
import com.example.library_mangament.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    private final UserRepo userRepo;

    public AuthService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void register(User user) {
        userRepo.save(user);
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
