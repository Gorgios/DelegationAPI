package com.example.elwart.user.exception;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String name){
        super("Role with id: " + name + " not found");
    }
}
