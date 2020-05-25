package com.gfieast.akademia.controller;

import java.util.List;

import com.gfieast.akademia.model.Note;
import com.gfieast.akademia.model.User;
import com.gfieast.akademia.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping(path = "/{login}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<User>> getUserNotes(@PathVariable String login) {
        return ResponseEntity.ok(userRepository.findAllByLoginStartsWithOrderByIdAsc(login));
    }

}
