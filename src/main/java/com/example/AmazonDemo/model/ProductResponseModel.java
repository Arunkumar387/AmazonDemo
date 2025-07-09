package com.example.AmazonDemo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseModel {

    public int productId;
    public String productName;
    public String description;
    public double quantity;
    public double price;
    public int categoryId;
    public String imageUrl;
}
