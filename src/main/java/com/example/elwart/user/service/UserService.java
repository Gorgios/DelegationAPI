package com.example.elwart.user.service;

import com.example.elwart.user.dto.UserDto;
import com.example.elwart.user.model.User;

public interface UserService {
    User registerUser(UserDto userDto);
}
