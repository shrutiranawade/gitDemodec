package com.example.Spring2day1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
@Autowired
UserRepository userRepository;
    public String addUser(User user){
userRepository.save(user);
return "User Added.";
    }
    public List<User>findAllUsers(){

        return userRepository.findAll();
    }
    public User findUserById(int id){
        return userRepository.findById(id).get();
    }
    public String deleteAllUser(){
        userRepository.deleteAll();
        return "All Users deleted .";
    }
    public String deleteUserById(int id){
        userRepository.deleteById(id);
        return "User Deleted.";
    }
}
