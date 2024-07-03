package com.example.courseLibrary;

import com.example.courseLibrary.entity.Author;
import com.example.courseLibrary.entity.Book;
import com.example.courseLibrary.entity.Category;
import com.example.courseLibrary.entity.Publisher;
import com.example.courseLibrary.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourseLibraryApplication {

	public static void main(String[] args) {

		SpringApplication.run(CourseLibraryApplication.class, args);
	}

	//generating dummy data for populating the database with values
	@Bean
	public CommandLineRunner initialData(BookService bookService) {
		return args -> {

			Book book1 = new Book("ABC" , "BOOK NAME" , "mYFIRSTbOOK");
			Author auth1 = new Author("Jack", "BOOK AUTHOR");
			Category cat1 = new Category("JAVA");
			Publisher pub1 = new Publisher("MY PUBLISHER");
			book1.addAuthor(auth1);
			book1.addCategory(cat1);
			book1.addPublisher(pub1);
			bookService.createBook(book1);

			Book book2 = new Book("ABC2" , "BOOK NAME2" , "mYFIRSTbOOK2");
			Author auth2 = new Author("Jack2", "BOOK AUTHOR2");
			Category cat2 = new Category("JAVA2");
			Publisher pub2 = new Publisher("MY PUBLISHER2");
			book2.addAuthor(auth2);
			book2.addCategory(cat2);
			book2.addPublisher(pub2);
			bookService.createBook(book2);

			Book book3 = new Book("ABC3" , "BOOK NAME3" , "mYFIRSTbOOK3");
			Author auth3 = new Author("Jack3", "BOOK AUTHOR3");
			Category cat3 = new Category("JAVA3");
			Publisher pub3 = new Publisher("MY PUBLISHER3");
			book3.addAuthor(auth3);
			book3.addCategory(cat3);
			book3.addPublisher(pub3);
			bookService.createBook(book3);


		};
	}

}
