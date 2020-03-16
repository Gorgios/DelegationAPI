package com.example.elwart.user.service;

import com.example.elwart.user.dto.UserDto;
import com.example.elwart.user.model.User;

import java.util.List;

public interface UserService {
    void registerUser(UserDto userDto);

    List<User> getAllUsers();

    void changePassword(Long userId, String password);

    boolean deleteUserById(Long userId);

    boolean removeDelegation(Long userId, Long delegationId);
}
