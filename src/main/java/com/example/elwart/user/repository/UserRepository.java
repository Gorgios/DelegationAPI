package com.example.elwart.user.repository;

import com.example.elwart.user.model.Role;
import com.example.elwart.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByRolesContains(Role role);
}
