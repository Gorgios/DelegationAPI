package com.example.elwart.user.service;

import com.example.elwart.user.dto.UserDto;
import com.example.elwart.user.model.User;

import java.util.List;

public interface UserService {
    void registerUser(UserDto userDto);
    List<User> getAllUsers();
}
