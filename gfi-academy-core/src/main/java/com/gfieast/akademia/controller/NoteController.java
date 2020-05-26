package com.gfieast.akademia.controller;

import java.util.List;

import com.gfieast.akademia.representation.NoteRepresentation;
import com.gfieast.akademia.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<NoteRepresentation>> getAllNotes() {
        return ResponseEntity.ok(noteService.findAll());
    }

    @GetMapping(path = "/{noteId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<NoteRepresentation> getNoteById(@PathVariable Long noteId) {
        return ResponseEntity.of(noteService.findOne(noteId));
    }

    @PostMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<NoteRepresentation> addNote(@PathVariable Long userId, @RequestBody NoteRepresentation noteRepresentation) {
        return ResponseEntity.ok(noteService.addNoteToUser(userId, noteRepresentation));
    }

    @PutMapping(path = "/{noteId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<NoteRepresentation> updateNote(@PathVariable Long noteId, @RequestBody NoteRepresentation noteRepresentation) {
        noteRepresentation.setId(noteId);
        return ResponseEntity.ok(noteService.updateNote(noteRepresentation));
    }

    @DeleteMapping(path = "/{noteId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<NoteRepresentation> deleteNote(@PathVariable Long noteId) {
        return ResponseEntity.ok(noteService.deleteNote(noteId));
    }

}
