package com.example.library_mangament.controllers;


import com.example.library_mangament.modals.Book;
import com.example.library_mangament.modals.ResponseApi;
import com.example.library_mangament.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "*")
public class BookController {


    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("books")
    public ResponseEntity getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooks());
    }

    @PostMapping("books")
    public ResponseEntity addBook(@RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseApi("book created", "201"));
    }


@DeleteMapping("books/{bookId}")
public ResponseEntity deleteBook(@PathVariable Integer bookId){
    bookService.deleteBook(bookId);
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseApi("book created", "200"));
}


//    @PutMapping("{bookId}/authors/{authorId}")
//    public ResponseEntity addBookToAuthor( @PathVariable Integer bookId, @PathVariable Integer authorId){
//        bookService.addBookToAuthor(bookId, authorId);
//
//        return ResponseEntity.status(HttpStatus.OK).body(new ResponseApi("book is added", "200"));
//    }
//
//    @PutMapping("{bookId}/author/{authorId}")
//    public ResponseEntity removeBookFromAuthor( @PathVariable Integer bookId, @PathVariable Integer authorId){
//        bookService.removeBookFromAuthor(bookId, authorId);
//
//        return ResponseEntity.status(HttpStatus.OK).body(new ResponseApi("book is added", "200"));
//    }

}
