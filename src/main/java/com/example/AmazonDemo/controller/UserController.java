package com.example.AmazonDemo.controller;

import com.example.AmazonDemo.entity.User;
import com.example.AmazonDemo.model.UserRequestModel;
import com.example.AmazonDemo.model.UserResponseModel;
import com.example.AmazonDemo.service.UserService;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public UserResponseModel registerUser(@RequestBody UserRequestModel userRequestModel){
        return userService.saveUser(userRequestModel);
    }

    @GetMapping("/getUser")
    public Optional<User> getUser(@RequestParam String userName){
        return userService.getUser(userName);
    }

    @GetMapping("/login")
    public String login(@RequestParam String userName,@RequestParam String password){
        return userService.login(userName, password);
    }

    @GetMapping("/git")
    public void gitCommands(@RequestParam String repoLink,@RequestParam String branchName,@RequestParam String fileName) throws GitAPIException{
        userService.createBranchAndPullCodeFromRepo(repoLink,branchName,fileName);
    }
}
