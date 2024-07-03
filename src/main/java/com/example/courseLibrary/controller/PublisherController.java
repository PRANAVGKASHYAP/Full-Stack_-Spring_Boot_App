package com.example.courseLibrary.controller;

import com.example.courseLibrary.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.courseLibrary.service.PblisherService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublisherController {

    @Autowired
    private PblisherService publisherService;

    @GetMapping("/publishers")
    public String findAllPublishers(Model model) {
        model.addAttribute("publishers" , publisherService.getAllPublishers());
        return "publishers";
    }

    //adding mapping to delete publishers
    @GetMapping("/remove-publisher/{id}")
    public String removePublisher(@PathVariable long id , Model model)
    {
        publisherService.deletePublisher(id);
        model.addAttribute("publishers" , publisherService.getAllPublishers());
        return "publishers";
    }

    //adding endpoints to update publisher
    @GetMapping("/edit-publisher/{id}")
    public String updatePublisher(@PathVariable long id , Model model)
    {
        //get the required publisher and add only that category to the model
        model.addAttribute("publishers" , publisherService.getPublisher(id));
        return "update-publisher";
    }

    @PostMapping("/save-piblisher/{id}")
    public String saveUpdate(@PathVariable long id , Publisher publisher, BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            return "update-publisher";
        }

        publisherService.updatePublisher(publisher);
        model.addAttribute("publishers" , publisherService.getAllPublishers());
        return "publishers";
    }

    //adding publisher
    @GetMapping("/add-publisher")
    public String addPublisher( Publisher publisher)
    {
        return "add-publisher";
    }

    @PostMapping("/save-publisher")
    public String savePublisher(Publisher publisher, BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            return "add-publisher";
        }

        publisherService.createPublisher(publisher);
        model.addAttribute("publishers" , publisherService.getAllPublishers());
        return "publishers";
    }

}
