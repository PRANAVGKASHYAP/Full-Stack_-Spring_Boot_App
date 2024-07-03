package com.example.courseLibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // this is the controller for the home page
    @GetMapping("/")
    public String index()
    {
        return "index";
    }
}
