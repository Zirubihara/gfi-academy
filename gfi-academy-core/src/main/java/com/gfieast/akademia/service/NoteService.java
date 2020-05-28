package com.gfieast.akademia.service;


import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.gfieast.akademia.converter.NoteToRepresentation;
import com.gfieast.akademia.exception.NoteNotFoundException;
import com.gfieast.akademia.exception.UserNotFoundException;
import com.gfieast.akademia.model.Note;
import com.gfieast.akademia.model.User;
import com.gfieast.akademia.repository.NoteRepository;
import com.gfieast.akademia.repository.UserRepository;
import com.gfieast.akademia.representation.NoteRepresentation;
import org.springframework.stereotype.Service;

import static com.gfieast.akademia.util.DateTimeUtil.toLocalDateTime;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteService(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    public List<NoteRepresentation> findAll() {
        return noteRepository.findAll()
                .stream()
                .map(NoteToRepresentation::convert)
                .collect(Collectors.toList());
    }

    public Optional<NoteRepresentation> findOne(Long noteId) {
        return noteRepository.findById(noteId).map(NoteToRepresentation::convert);
    }

    public NoteRepresentation addNoteToUser(Long userId, NoteRepresentation noteRepresentation) {
        final Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new UserNotFoundException(userId);
        }
        return addNote(user.get(), noteRepresentation);
    }

    private NoteRepresentation addNote(User user, NoteRepresentation noteRepresentation) {
        Note note = mapToNote(noteRepresentation);
        note.setUser(user);
        note = noteRepository.save(note);
        noteRepresentation.setId(note.getId());
        noteRepresentation.setCreationDate(toLocalDateTime(note.getCreationDate()));
        noteRepresentation.setModificationDate(toLocalDateTime(note.getModificationDate()));

        return noteRepresentation;
    }

    private Note mapToNote(NoteRepresentation noteRepresentation) {
        return Note.builder()
                .importance(noteRepresentation.getImportance())
                .title(noteRepresentation.getTitle())
                .text(noteRepresentation.getText())
                .creationDate(Instant.now())
                .modificationDate(Instant.now())
                .build();
    }

    public NoteRepresentation updateNote(NoteRepresentation noteRepresentation) {
        Optional<Note> note = noteRepository.findById(noteRepresentation.getId());
        Note dbNote = note.orElseThrow(() -> new NoteNotFoundException(noteRepresentation.getId()));
        dbNote.setImportance(noteRepresentation.getImportance());
        dbNote.setText(noteRepresentation.getText());
        dbNote.setTitle(noteRepresentation.getTitle());
        dbNote.setModificationDate(Instant.now());
        dbNote = noteRepository.save(dbNote);
        return NoteToRepresentation.convert(dbNote);
    }

    public NoteRepresentation deleteNote(Long noteId) {
        Optional<Note> note = noteRepository.findById(noteId);
        Note dbNote = note.orElseThrow(() -> new NoteNotFoundException(noteId));
        noteRepository.delete(dbNote);
        return NoteToRepresentation.convert(dbNote);
    }
}
