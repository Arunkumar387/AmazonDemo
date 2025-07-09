package com.example.AmazonDemo.model;

import com.example.AmazonDemo.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryResponseModel {
    public int categoryId;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String categoryName;
    public List<Product> productList = new ArrayList<>();


}
