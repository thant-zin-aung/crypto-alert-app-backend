package com.panda.cryptoalertapp.controllers;

import com.panda.cryptoalertapp.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/saveUser")
    public ResponseEntity<Object> saveUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        userService.saveUser(username, email, password);
        return ResponseEntity.ok("User saved successfully...");
    }
}
