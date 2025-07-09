package com.example.AmazonDemo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class User {

    String firstName;
    String lastName;
    long mobileNumber;
    String email;
    @Id
    String userName;
    String password;
}
