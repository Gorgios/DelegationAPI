package com.example.elwart.user.service;

import com.example.elwart.user.dto.UserDto;
import com.example.elwart.user.exception.RoleNotFoundException;
import com.example.elwart.user.model.Role;
import com.example.elwart.user.model.User;
import com.example.elwart.user.repository.RoleRepository;
import com.example.elwart.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User registerUser(UserDto userDto) {
        User user = User.UserBuilder.anUser().withName(userDto.getName()).withFullName(userDto.getFullName()).
                withCompanyAddress(userDto.getCompanyAddress()).
                withCompanyName(userDto.getCompanyName()).withCompanyNip(userDto.getCompanyNip()).
                withEmail(userDto.getEmail()).
                withPassword(userDto.getPassword()).withRoles(getRoles(userDto.getRoles())).build();
        return  userRepository.save(user);
    }

    private List<Role> getRoles(List<String> roles) {
        List<Role> roleList = new ArrayList<>();
        if (roles == null)
            roleList.add(roleRepository.findByRole("ROLE_USER").orElseThrow(()-> new RoleNotFoundException("ROLE_USER")));
        else
            roles.forEach(r -> roleList.add(roleRepository.findByRole(r).orElseThrow(() -> new RoleNotFoundException(r))));
        return roleList;
    }
}
