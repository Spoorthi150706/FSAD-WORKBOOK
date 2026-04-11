package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.User;
import com.klu.repository.UserRepository;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository repo;

    // Register
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return repo.save(user);
    }

    // Login
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User u = repo.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (u == null) {
            throw new RuntimeException("Invalid credentials");
        }

        return u;
    }

    // Get user by ID
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }
}