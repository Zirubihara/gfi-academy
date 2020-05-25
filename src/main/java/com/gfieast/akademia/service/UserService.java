package com.gfieast.akademia.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.gfieast.akademia.converter.NoteToRepresentation;
import com.gfieast.akademia.converter.UserToRepresentation;
import com.gfieast.akademia.converter.UserToUserWithNoteRepresentation;
import com.gfieast.akademia.exception.UserNotFoundException;
import com.gfieast.akademia.model.User;
import com.gfieast.akademia.repository.NoteRepository;
import com.gfieast.akademia.repository.UserRepository;
import com.gfieast.akademia.representation.UserRepresentation;
import com.gfieast.akademia.representation.UserWithNotesRepresentation;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final NoteRepository noteRepository;

    public UserService(UserRepository userRepository, NoteRepository noteRepository) {
        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
    }

    public List<UserRepresentation> getAllUsers() {
        return userRepository.findAll().stream().map(UserToRepresentation::convert).collect(Collectors.toList());
    }

    public UserWithNotesRepresentation getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        UserWithNotesRepresentation userWithNotesRepresentation = user.map(UserToUserWithNoteRepresentation::convert).orElseThrow(() -> new UserNotFoundException(userId));
        userWithNotesRepresentation.setNotes(noteRepository.findAllByUserId(userWithNotesRepresentation.getId()).stream().map(NoteToRepresentation::convert).collect(Collectors.toList()));

        return userWithNotesRepresentation;
    }

}