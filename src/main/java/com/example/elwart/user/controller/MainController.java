package com.example.elwart.user.controller;

import com.example.elwart.user.dto.UserDto;
import com.example.elwart.user.model.User;
import com.example.elwart.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public void registerUser(@RequestBody UserDto userDto) {
        userService.registerUser(userDto);
    }

    @PutMapping("/user/change_password/{id}")
    public void changePassword(@PathVariable Long id, @RequestParam String password) {
        userService.changePassword(id, password);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUserById(@PathVariable Long id) {
       return userService.deleteUserById(id);
    }


}
