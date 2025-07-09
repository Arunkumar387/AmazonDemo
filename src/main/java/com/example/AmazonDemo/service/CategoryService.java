package com.example.AmazonDemo.service;

import com.example.AmazonDemo.entity.Category;
import com.example.AmazonDemo.mapper.ECommerceMapper;
import com.example.AmazonDemo.model.CategoryRequestModel;
import com.example.AmazonDemo.model.CategoryResponseModel;
import com.example.AmazonDemo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    ECommerceMapper eCommerceMapper;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getCategory(){
         return categoryRepository.findAll();
    }

    public CategoryResponseModel saveCategory(CategoryRequestModel categoryRequestModel){
       Category mm = eCommerceMapper.categoryToEntity(categoryRequestModel);
       CategoryResponseModel categoryResponseModel= eCommerceMapper.entityToCategory(mm);
       categoryRepository.save(mm);
       return  categoryResponseModel;
    }

    public Optional<Category> getCategoryById(int id){
        if(categoryRepository.existsById(id)){
            Optional<Category> category = categoryRepository.findById(id);
            return category;
        }
        else{
            return null;
        }
    }

    public String deleteCategoryById(int id){
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return "Category deleted successfully";
        }
        else{
            return "No Such Category";
        }
    }
}
