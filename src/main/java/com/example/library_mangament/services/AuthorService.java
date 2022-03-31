package com.example.library_mangament.services;

import com.example.library_mangament.modals.Author;
import com.example.library_mangament.repo.AuthorRepo;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class AuthorService {


    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public List<Author> getAuthors() {


        return authorRepo.findAll();
    }

    public void addAuthor(Author author){


        authorRepo.save(author);
    }


}
