package com.maticar.controller;


import com.maticar.model.User;
import com.maticar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAllUsers")
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> response =  userService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
