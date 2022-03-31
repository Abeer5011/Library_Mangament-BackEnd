package com.example.library_mangament.repo;

import com.example.library_mangament.modals.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
//
//    @Query("select u from Book u where u.author=?1")
//    Book findByAuthorName(Integer author);
}
