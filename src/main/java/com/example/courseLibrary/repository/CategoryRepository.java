package com.example.courseLibrary.repository;

import com.example.courseLibrary.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    //data access layer for the category table
}
