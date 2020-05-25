package com.gfieast.akademia.exception;

import static java.lang.String.format;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(Long noteId) {
        super(format("Note with id %s not found", noteId));
    }
}
