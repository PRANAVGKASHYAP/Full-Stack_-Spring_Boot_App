package com.example.courseLibrary.repository;

import com.example.courseLibrary.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    //data access layer for publisher entity
}
