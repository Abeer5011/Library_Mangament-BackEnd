package com.example.library_mangament.services;
import com.example.library_mangament.modals.Author;
import com.example.library_mangament.modals.Book;
import com.example.library_mangament.repo.AuthorRepo;
import com.example.library_mangament.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;



    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    public void addBook(Book book) {
        Author author = authorRepo.getById(book.getAuthor_id());

     book.addAuthor(author);

        bookRepo.save(book);

    }

    public void deleteBook(Integer bookId) {
        bookRepo.deleteById(bookId);
    }


//    public void addBookToAuthor(Integer bookId, Integer authorId){
//        Book book = bookRepo.findById(bookId).get();
//        Author author = authorRepo.findById(authorId).get();
//
//        author.addBookToAuthor(book);
//
//           authorRepo.save(author);
//    }
//
//    public void removeBookFromAuthor(Integer bookId, Integer authorId){
//        Book book = bookRepo.findById(bookId).get();
//        Author author = authorRepo.findById(authorId).get();
//
//        author.removeBookFormAuthor(book);
//
//        authorRepo.save(author);
//    }
}
