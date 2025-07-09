package com.example.AmazonDemo.mapper;

import com.example.AmazonDemo.entity.Category;
import com.example.AmazonDemo.entity.Product;
import com.example.AmazonDemo.entity.User;
import com.example.AmazonDemo.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ECommerceMapper {

    ECommerceMapper INSTANCE = Mappers.getMapper(ECommerceMapper.class);


    @Mapping(source = "categoryId", target = "category.categoryId")
    Product productToEntity(ProductRequestModel productRequestModel);

    @Mapping(source = "category.categoryId", target = "categoryId")
    ProductResponseModel entityToProduct(Product product);

     CategoryResponseModel entityToCategory(Category category);
     Category categoryToEntity(CategoryRequestModel categoryRequestModel);

     User userToEntity(UserRequestModel userRequestModel);
     UserResponseModel entityToUser(User user);
}
