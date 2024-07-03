package com.example.courseLibrary.service;

import com.example.courseLibrary.entity.Category;
import com.example.courseLibrary.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //methods

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElseThrow( () -> new RuntimeException("Category not found"));
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(long id) {
        Category category = categoryRepository.findById(id).orElseThrow( () -> new RuntimeException("Category not found"));
        categoryRepository.delete(category);
    }
}
