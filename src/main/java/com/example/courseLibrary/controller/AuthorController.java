package com.example.courseLibrary.controller;

import com.example.courseLibrary.entity.Author;
import com.example.courseLibrary.entity.Publisher;
import com.example.courseLibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    //finding all the authors
    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public String listAuthors(Model model)
    {
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }

    //adding mapping to remove author
    @GetMapping("/remove-author/{id}")
    public String removeAuthor(@PathVariable long id, Model model)
    {
        //1. deleting the author with the is
        authorService.deleteAuthor(id);
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }


    // mapping to edit the author
    @GetMapping("/edit-author/{id}")
    public String updateAuthor(@PathVariable long id, Model model)
    {
        model.addAttribute("authors", authorService.findById(id));
        return "update-author";
    }


    @PostMapping("/save-author/{id}")
    public String saveUpdate(@PathVariable long id, @ModelAttribute Author author, BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            return "update-author";
        }

        //calling the service
        authorService.updateAuthor(author);
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }

    //mappings for adding authors
    @GetMapping("/add-author")
    public String addAuthor( Author author)
    {
        return "add-author";
    }

    @PostMapping("/save-author")
    public String saveAuthor(Author author, BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            return "add-author";
        }

        authorService.createAuthor(author);
        model.addAttribute("authors" , authorService.findAll());
        return "authors";
    }

}
