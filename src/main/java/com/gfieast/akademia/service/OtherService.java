package com.gfieast.akademia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherService {

    private final NoteService noteService;
    private final UserService userService;

    @Autowired
    public OtherService(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
        userService.printName();
    }
}
