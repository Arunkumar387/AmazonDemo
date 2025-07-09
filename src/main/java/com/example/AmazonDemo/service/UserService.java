package com.example.AmazonDemo.service;

import com.example.AmazonDemo.entity.User;
import com.example.AmazonDemo.mapper.ECommerceMapper;
import com.example.AmazonDemo.model.UserRequestModel;
import com.example.AmazonDemo.model.UserResponseModel;
import com.example.AmazonDemo.repository.UserRepository;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    ECommerceMapper eCommerceMapper;
    @Autowired
    UserRepository userRepository;

    public UserResponseModel saveUser(UserRequestModel userRequestModel){
        User ec = eCommerceMapper.userToEntity(userRequestModel);
        userRepository.save(ec);
        UserResponseModel ur = eCommerceMapper.entityToUser(ec);
        return ur;
    }

    public Optional<User> getUser(String userName){
        if(userRepository.existsById(userName)){
            Optional<User> ur = userRepository.findById(userName);
            return ur;
        }
        else{
            return null;
        }
    }

    public String login(String userName, String password){
        if(userRepository.existsById(userName)){
            Optional<User> user = userRepository.findById(userName);
            if(password.equals(user.get().getPassword())) {
                return user.get().getFirstName();
            }
            else{
                return "Incorrect Password";
            }
        }
        else{
            return "Register First";
        }
    }


    public void createBranchAndPullCodeFromRepo(String repoLink,String branchName,String fileName) throws GitAPIException {
        Git git = Git.cloneRepository()
                .setURI(repoLink)
                .setDirectory(new File(fileName))
                .call();

        git.checkout().setName("dev").call();
        git.pull().call();

//        String branchName = "feature/JIRA-123-remove-flag";
        git.checkout().setCreateBranch(true).setName(branchName).call();

        System.out.println("Created and switched to branch: " + branchName);
    }
}
