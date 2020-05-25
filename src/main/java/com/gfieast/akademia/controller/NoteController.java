package com.gfieast.akademia.controller;

import java.util.List;

import com.gfieast.akademia.model.Note;
import com.gfieast.akademia.service.NoteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAll());
    }

    @GetMapping(path = "/{noteId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Note> getNoteById(@PathVariable Long noteId) {
        return ResponseEntity.ok(noteService.getNoteById(noteId));
    }

}
