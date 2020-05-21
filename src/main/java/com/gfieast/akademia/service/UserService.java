package com.gfieast.akademia.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService {

    private final NoteService noteService;

    public UserService(NoteService noteService) {
        this.noteService = noteService;
    }

    public void printName() {
        log.info("===== Printing name in UserService.");
        log.info("===== Name is: {}", noteService.getName());
    }
}
