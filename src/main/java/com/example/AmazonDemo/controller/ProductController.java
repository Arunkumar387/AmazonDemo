package com.example.AmazonDemo.controller;

import com.example.AmazonDemo.entity.Product;
import com.example.AmazonDemo.model.ProductRequestModel;
import com.example.AmazonDemo.model.ProductResponseModel;
import com.example.AmazonDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/saveProduct")
    public ProductResponseModel saveProduct(@RequestBody ProductRequestModel productRequestModel){
        return productService.saveProduct(productRequestModel);

    }

    @GetMapping("/getProduct")
    public List<Product> getProduct(){
        return productService.getProduct();
    }

    @GetMapping("/getProductById")
    public Optional<Product> getProductById(@RequestParam int id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/deleteProductById")
    public String deleteProduct(@RequestParam int id){
        return productService.deleteProductById(id);
    }
}
