package com.example.elwart.user.controller;

import com.example.elwart.user.dto.UserDto;
import com.example.elwart.user.model.User;
import com.example.elwart.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public User registerUser(@RequestBody UserDto userDto){
        return userService.registerUser(userDto);
    }

}
