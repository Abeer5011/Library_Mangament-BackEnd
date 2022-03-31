package com.example.library_mangament.modals;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    @Column(name = "author_id",insertable = false,updatable = false)
    private Integer author_id;

    @ManyToOne
    @JoinColumn(name = "author_id",  nullable = false)
    private Author author;

    public void addAuthor(Author author) {
      this.author = author;

    }
}
