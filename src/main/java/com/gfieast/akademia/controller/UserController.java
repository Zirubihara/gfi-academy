package com.gfieast.akademia.controller;

import java.util.List;
import javax.validation.Valid;

import com.gfieast.akademia.representation.UserRepresentation;
import com.gfieast.akademia.representation.UserWithNotesRepresentation;
import com.gfieast.akademia.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    ResponseEntity<List<UserRepresentation>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<UserWithNotesRepresentation> getUserById(@PathVariable Long userId) {
        return ResponseEntity.of(userService.getUserById(userId));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<UserRepresentation> addUser(@RequestBody @Valid UserRepresentation user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<UserRepresentation> updateUser(@PathVariable Long userId, @RequestBody @Valid UserRepresentation user) {
        user.setId(userId);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<UserWithNotesRepresentation> deleteUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }
}
