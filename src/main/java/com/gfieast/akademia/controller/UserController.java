package com.gfieast.akademia.controller;

import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @GetMapping
    List<String> names() {
        return Arrays.asList("ANIA", "MANIA", "WOJTEK", "STASZEK");
    }

    @GetMapping("/{text}/{number}")
    ResponseEntity<String> printLog(@PathVariable String text, @PathVariable Long number) {
        log.error("To jest text [{}], a to jest liczba [{}]", text, number);
        return ResponseEntity.status(HttpStatus.CREATED).body("PRINTED");
    }
}
