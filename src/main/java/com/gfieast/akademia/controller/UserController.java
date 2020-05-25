package com.gfieast.akademia.controller;

import java.util.List;

import com.gfieast.akademia.model.User;
import com.gfieast.akademia.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<User> getUserNotes(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

}
