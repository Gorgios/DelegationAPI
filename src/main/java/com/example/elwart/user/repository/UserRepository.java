package com.example.elwart.user.repository;

import com.example.elwart.user.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
