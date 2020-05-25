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
        return userRepository.findAll()
                .stream()
                .map(UserToRepresentation::convert)
                .collect(Collectors.toList());
    }

    public Optional<UserWithNotesRepresentation> getUserById(Long userId) {
        Optional<UserWithNotesRepresentation> user = userRepository.findById(userId).map(UserToUserWithNoteRepresentation::convert);
        user.ifPresent(userRepresentation ->
                userRepresentation.setNotes(noteRepository.findAllByUserId(userId)
                        .stream()
                        .map(NoteToRepresentation::convert)
                        .collect(Collectors.toList())));
        return user;
    }

    public UserRepresentation addUser(UserRepresentation user) {
        return UserToRepresentation.convert(userRepository.save(mapToUser(user)));
    }

    public UserRepresentation updateUser(UserRepresentation user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        User dbUser = optionalUser.orElseThrow(() -> new UserNotFoundException(user.getId()));
        dbUser.setLogin(user.getLogin());
        dbUser.setFullName(user.getFullName());

        return user;
    }

    public UserWithNotesRepresentation deleteUser(Long userId) {
        User dbUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        noteRepository.deleteAll(noteRepository.findAllByUserId(userId));
        userRepository.deleteById(userId);
        return UserToUserWithNoteRepresentation.convert(dbUser);
    }

    private User mapToUser(UserWithNotesRepresentation source) {
        return User.builder()
                .login(source.getLogin())
                .fullName(source.getFullName())
                .build();
    }

    private User mapToUser(UserRepresentation source) {
        return User.builder()
                .login(source.getLogin())
                .fullName(source.getFullName())
                .build();
    }

}