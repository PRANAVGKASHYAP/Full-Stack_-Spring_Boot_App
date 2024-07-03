package com.example.courseLibrary.repository;

import com.example.courseLibrary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    //this repo is for the author table
}
