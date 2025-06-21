package com.panda.cryptoalertapp.controllers;

import com.panda.cryptoalertapp.entities.User;
import com.panda.cryptoalertapp.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }
}
