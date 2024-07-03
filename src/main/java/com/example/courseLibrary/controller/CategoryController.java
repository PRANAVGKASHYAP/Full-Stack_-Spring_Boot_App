package com.example.courseLibrary.controller;

import com.example.courseLibrary.entity.Category;
import com.example.courseLibrary.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    //getting the categories
    @GetMapping("/categories")
    public String Getcategories(Model model)
    {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    //mapping for deleting the category
    @GetMapping("remove-category/{id}")
    public String RemoveCategory(@PathVariable int id, Model model)
    {
        categoryService.deleteCategory(id);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    //mapping for editing the categories
    @GetMapping("/update-category/{id}")
    public String updateCategory(@PathVariable long id , Model model)
    {
        model.addAttribute("categories" , categoryService.getCategoryById(id));
        return "update-category";

    }

    @PostMapping("/save-category/{id}")
    public String saveCategory(@PathVariable long id , Category category , BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            return "update-category";
        }

        categoryService.updateCategory(category);

        model.addAttribute("categories", categoryService.getAllCategories());
        return "redirect:/categories";
    }

    //adding a category
    @GetMapping("/add-category")
    public String showCategory(Category category)
    {
        return "add-category";
    }

    @PostMapping("/save-category")
    public String saveCategory( Category category , BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            return "add-category";
        }

        categoryService.createCategory(category);

        model.addAttribute("categories", categoryService.getAllCategories());
        return "redirect:/categories";

    }
}
