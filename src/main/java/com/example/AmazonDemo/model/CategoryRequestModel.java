package com.example.AmazonDemo.model;


import java.util.ArrayList;
import java.util.List;

public class CategoryRequestModel {
    public String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ProductRequestModel> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductRequestModel> productList) {
        this.productList = productList;
    }

    public List<ProductRequestModel> productList = new ArrayList<>();

}
