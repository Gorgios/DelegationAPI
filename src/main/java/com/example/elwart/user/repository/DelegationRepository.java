package com.example.elwart.user.repository;

import com.example.elwart.user.model.Delegation;
import com.example.elwart.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface DelegationRepository  extends CrudRepository<Delegation,Long> {
    List<Delegation> findAllByOrderByDateTimeStartDesc();
    List<Delegation> findDelegationsByUserOrderByDateTimeStartDesc(User user);
}
