package com.example.courseLibrary.service;

import com.example.courseLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.courseLibrary.entity.Book;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //method to find all the books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //getting book by id
    public Book getBookById(long id) {
        return bookRepository.findById(id).orElseThrow( () -> new RuntimeException(("book not found")));

    }

    //saving the book
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    //deleting the book of given id
    public void deleteBookById(long id) {

        Book book = bookRepository.findById(id).orElseThrow( () -> new RuntimeException(("book not found")));
        bookRepository.deleteById(book.getId());
    }

    //writing a method to save the updated book
    public void updateBook(Book book) {
        bookRepository.save(book);
    }
}
