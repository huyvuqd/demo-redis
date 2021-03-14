package com.example.demoredis.controller;

import com.example.demoredis.model.User;
import com.example.demoredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        boolean result = userService.saveUser(user);
        if (result = true) {
            return ResponseEntity.ok("Add successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/user")

    public ResponseEntity<List<User>> fetchAllUsers() {
        List<User> users = userService.fetchAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> fetchUserById(@PathVariable("id") Long id) {
        User user = userService.fetchUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        boolean result = userService.deleteUser(id);
        if (result) {
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
