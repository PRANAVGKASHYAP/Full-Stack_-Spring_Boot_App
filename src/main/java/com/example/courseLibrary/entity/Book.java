package com.example.courseLibrary.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


//using lonbok to generate getter and setter
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false , name = "name" , length = 50)
    private String name;

    @Column(unique = true , nullable = false , name = "description" , length = 50)
    private String description;

    @Column(unique = true , nullable = false , name = "isbn" , length = 50)
    private String isbn;

    // creating mapping
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_author",
    joinColumns = {@JoinColumn(name = "book_id")},
    inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authors = new HashSet<Author>();


    // mapping for category

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_categories",
    joinColumns = {@JoinColumn(name = "book_id")},
    inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Category> categories = new HashSet<Category>();

    //creating mapping for publisher
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_publishers",
    joinColumns = {@JoinColumn(name = "book_id")},
    inverseJoinColumns = {@JoinColumn(name = "publisher_id")})
    private Set<Publisher> publishers = new HashSet<Publisher>();

    //since there is a bidirectional relationship of book and other entities we need to handel the addition and deletion
    //of book object saperately

    // --> publisher
    public void removePublisher(Publisher publisher) {
        this.publishers.remove(publisher);

        //remove this book from the publisher table/entity also
        publisher.getBooks().remove(publisher);
    }

    public void addPublisher(Publisher publisher) {
        this.publishers.add(publisher);

        //add this book to the publisher table/entity also
        publisher.getBooks().add(this);
    }

    // --> author
    public void removeAuthor(Author author) {
        this.authors.remove(author);

        //remove this book from the publisher table/entity also
        author.getBooks().remove(author);
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
        author.getBooks().add(this);
    }

    // -->category
    public void removeCategory(Category category) {
        this.categories.remove(category);
        category.getBooks().remove(category);
    }

    public void addCategory(Category category) {
        this.categories.add(category);
        category.getBooks().add(this);
    }

    public Book(String name, String description, String isbn) {
        this.name = name;
        this.description = description;
        this.isbn = isbn;
    }
}
