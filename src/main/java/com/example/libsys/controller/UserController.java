package com.example.libsys.controller;

import com.example.libsys.model.UserEntity;
import com.example.libsys.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @PostConstruct
//    public void initRoleAndUser() {
//        userService.initRoleAndUser();
//    }

//    @PostMapping({"/registerNewUser"})
//    public UserEntity registerNewUser(@RequestBody UserEntity user) {
//        return userService.registerNewUser(user);
//    }

}