package com.example.AmazonDemo.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int productId;

    public String productName;
    public String description;
    public double quantity;
    public double price;
    public String imageUrl;

    @ManyToOne
    @JoinColumn(name= "categoryId")
    @JsonBackReference
   public Category category;

}
