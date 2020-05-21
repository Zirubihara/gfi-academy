package com.gfieast.akademia.service;

public class OtherService {

    private final NoteService noteService;
    private final UserService userService;


    public OtherService(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
        userService.printName();
    }
}
