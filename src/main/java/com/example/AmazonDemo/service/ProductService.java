package com.example.AmazonDemo.service;

import com.example.AmazonDemo.entity.Category;
import com.example.AmazonDemo.entity.Product;
import com.example.AmazonDemo.mapper.ECommerceMapper;
import com.example.AmazonDemo.model.ProductRequestModel;
import com.example.AmazonDemo.model.ProductResponseModel;
import com.example.AmazonDemo.repository.CategoryRepository;
import com.example.AmazonDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ECommerceMapper eCommerceMapper;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;


    public ProductResponseModel saveProduct(ProductRequestModel productRequestModel){
        Product pp = eCommerceMapper.productToEntity(productRequestModel);
        ProductResponseModel productResponseModel= eCommerceMapper.entityToProduct(pp);
        productRepository.save(pp);
        return productResponseModel;
    }

    public Product saveProductWithCategory(Product product, int categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);
        return productRepository.save(product);
    }

        public Optional<Product> getProductById(int id) {
            if (productRepository.existsById(id)) {
                Optional<Product> product = productRepository.findById(id);
                return product;
            } else {
                return null;
            }
        }

        public List<Product> getProduct(){
        if(productRepository != null){
            return productRepository.findAll();
        }
        else{
            return null;
        }
        }


        public String deleteProductById(int id){
            if(productRepository.existsById(id)){
                productRepository.deleteById(id);
                return "Deleted Successfull";
            }
            else{
                return "No such Product exists";
            }
        }

    }

