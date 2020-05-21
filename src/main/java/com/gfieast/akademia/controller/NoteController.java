package com.gfieast.akademia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;

@RestController
@RequestMapping("/note")
public class NoteController {

    @RequestMapping(method = RequestMethod.GET)
    public String returnNote() {
        return "THIS IS SECRET NOTE";
    }

    @GetMapping("/{param}")
    public ResponseEntity<String> returnNoteWithParam(@PathVariable String param) {
        return ResponseEntity.ok(format("Note with param from URI: %s", param));
    }
}
