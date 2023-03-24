package com.example.Spring2day1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/addUser")
    public String add(@RequestBody  User user){
        return userService.addUser(user);

    }
    @GetMapping("/get-users")
    public List<User> getAllUsers(){
        return userService.findAllUsers();

    }
    @GetMapping("/get-user-by-id")
    public User getUserById(@RequestParam int id){
        return userService.findUserById(id);

    }
    @DeleteMapping("/delete-user-by-id")
    public String deleteUser(@RequestParam int id){
        return  userService.deleteUserById(id);

    }
    @DeleteMapping("/delete-all-users")
    public String deleteAllUsers(){
        return  userService.deleteAllUser();

    }

}
