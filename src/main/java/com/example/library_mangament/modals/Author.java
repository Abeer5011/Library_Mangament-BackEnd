package com.example.library_mangament.modals;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;


@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;



    @OneToMany( cascade = CascadeType.ALL)
    private Set<Book> books;


    public void addBookToAuthor(Book book) {

        books.add(book);

    }

    public void removeBookFormAuthor(Book book) {
        books.remove(book);
    }
}
