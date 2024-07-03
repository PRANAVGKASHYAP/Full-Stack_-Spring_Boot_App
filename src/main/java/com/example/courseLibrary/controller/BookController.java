package com.example.courseLibrary.controller;


import com.example.courseLibrary.entity.Book;
import com.example.courseLibrary.service.AuthorService;
import com.example.courseLibrary.service.BookService;
import com.example.courseLibrary.service.CategoryService;
import com.example.courseLibrary.service.PblisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class BookController {

    //initializing the service onject
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PblisherService publisherService;

    @Autowired
    private AuthorService authorService;

    //defining the enpoints

    @GetMapping("/books")
    public String findAll(Model model)
    {
        List<Book>books  = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books"; // this is the name of the html file
    }

    @GetMapping("/book/{id}")
    public String findBook(@PathVariable  Long id, Model model)
    {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "list-book";
    }

    // creating a mapping for deleting a book
    @GetMapping("remove-book/{id}")
    public String deleteBook(@PathVariable  Long id , Model model)
    {
        bookService.deleteBookById(id);
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    // creating a mapping for updating and saving the book
    @GetMapping("update-book/{id}")
    public String updateBook(@PathVariable  Long id , Model model)
    {
        Book book = bookService.getBookById(id);

        //adding all the required services to the model
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("authors" , authorService.findAll());
        model.addAttribute("publishers", publisherService.getAllPublishers());
        model.addAttribute("books", book);

        return "update-book";
    }

    @PostMapping("/save-update/{id}")
    public String saveUpdates(@PathVariable Long id , Book book ,  BindingResult res , Model model)
    {
        // check if the form details have any error
        if(res.hasErrors())
        {
            return "update-book";
        }

        //if there are no errors then call the function of the book service
        bookService.updateBook(book);
        model.addAttribute("books", bookService.getAllBooks());
        return "redirect:/books";
    }

    // adding the mapping for adding the book
    @GetMapping("/add-book")
    public String addBook(Book book , Model model)
    {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("authors" , authorService.findAll());
        model.addAttribute("publishers", publisherService.getAllPublishers());
        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(Book book , BindingResult res , Model model)
    {
        if(res.hasErrors())
        {
            return "add-book";
        }

        bookService.createBook(book);
        model.addAttribute("books", bookService.getAllBooks());
        return "redirect:/books";
    }
}
