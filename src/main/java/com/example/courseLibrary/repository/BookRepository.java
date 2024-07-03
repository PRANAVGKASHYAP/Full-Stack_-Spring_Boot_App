package com.example.courseLibrary.repository;

import com.example.courseLibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    void deleteById(long id);
    // this is to communicate with the data access layer
}
