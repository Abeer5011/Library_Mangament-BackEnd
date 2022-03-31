package com.example.library_mangament.controllers;
import com.example.library_mangament.modals.Author;
import com.example.library_mangament.modals.ResponseApi;
import com.example.library_mangament.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "*")
public class AuthorController {



    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("authors")
    public ResponseEntity getAllAuthors(){
        return ResponseEntity.status(HttpStatus.OK).body(authorService.getAuthors());
    }

    @PostMapping("authors")
    public ResponseEntity addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseApi("author created", "201"));
    }

}

