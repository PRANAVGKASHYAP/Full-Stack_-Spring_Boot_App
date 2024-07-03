package com.example.courseLibrary.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // id will be the primary key

    //customizing the column names and te properties
    @Column(name = "name" , length = 100 , nullable = false , unique = true)
    private String name;
    @Column(name = "description" , length = 200 , nullable = false )
    private String description;

    //defining relationships
    @ManyToMany(mappedBy = "authors" , cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>(); // this initialization is done to prevent null values

    public Author(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
