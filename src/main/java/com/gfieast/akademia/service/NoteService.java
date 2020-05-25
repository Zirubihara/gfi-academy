package com.gfieast.akademia.service;


import java.util.List;

import com.gfieast.akademia.exception.NoteNotFoundException;
import com.gfieast.akademia.model.Note;
import com.gfieast.akademia.repository.NoteRepository;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long noteId) {
        return noteRepository.findById(noteId).orElseThrow(() -> new NoteNotFoundException(noteId));
    }
}
