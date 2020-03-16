package com.example.elwart.user.controller;

import com.example.elwart.user.dto.UserDto;
import com.example.elwart.user.model.User;
import com.example.elwart.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    public void registerUser(@RequestBody UserDto userDto){
        userService.registerUser(userDto);
    }
    @PutMapping("/change_password/{id}")
    public void changePassword(@PathVariable Long id, @RequestParam String password){
        userService.changePassword(id,password);
    }
    

}
