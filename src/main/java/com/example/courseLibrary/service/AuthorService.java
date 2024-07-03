package com.example.courseLibrary.service;

import com.example.courseLibrary.entity.Author;
import com.example.courseLibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    //initializing the repository
    @Autowired
    AuthorRepository authorRepository;

    //defining all the necessary methods
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(long id) {
        return authorRepository.findById(id).orElseThrow( () -> new RuntimeException( "Author not found" ) );
    }

    public void createAuthor(Author author){
        authorRepository.save(author);
    }

    public void updateAuthor(Author author){
        authorRepository.save(author);
    }

    public void deleteAuthor(long id){

        Author author = authorRepository.findById(id).orElseThrow( () -> new RuntimeException( "Author not found" ) );
        authorRepository.deleteById( author.getId() );
    }

    //



}
