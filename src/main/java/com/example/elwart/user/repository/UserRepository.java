package com.example.elwart.user.repository;

import com.example.elwart.user.model.Role;
import com.example.elwart.user.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByRoles(Role role);
}
