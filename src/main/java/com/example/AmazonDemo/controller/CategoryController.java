package com.example.AmazonDemo.controller;

import com.example.AmazonDemo.entity.Category;
import com.example.AmazonDemo.model.CategoryRequestModel;
import com.example.AmazonDemo.model.CategoryResponseModel;
import com.example.AmazonDemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/saveCategory")
    public CategoryResponseModel saveCategory(@RequestBody CategoryRequestModel categoryRequestModel){
        return categoryService.saveCategory(categoryRequestModel);
    }

    @GetMapping("/getCategory")
    public List<Category> getCategory(){
        return categoryService.getCategory();
    }

    @GetMapping("/getCategoryById")
    public Optional<Category> getCategoryById(@RequestParam int id) {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/deleteCategoryById")
    public String deleteCategory(@RequestParam int id){
        return categoryService.deleteCategoryById(id);
    }
}