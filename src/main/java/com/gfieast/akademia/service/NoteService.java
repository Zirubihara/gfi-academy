package com.gfieast.akademia.service;


import java.util.List;
import java.util.stream.Collectors;

import com.gfieast.akademia.converter.NoteToRepresentation;
import com.gfieast.akademia.exception.NoteNotFoundException;
import com.gfieast.akademia.repository.NoteRepository;
import com.gfieast.akademia.representation.NoteRepresentation;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<NoteRepresentation> getAll() {
        return noteRepository.findAll().stream().map(NoteToRepresentation::convert).collect(Collectors.toList());
    }

    public NoteRepresentation getNoteById(Long noteId) {
        return noteRepository.findById(noteId)
                .map(NoteToRepresentation::convert)
                .orElseThrow(() -> new NoteNotFoundException(noteId));
    }
}
