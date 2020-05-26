package com.gfieast.akademia.converter;

import com.gfieast.akademia.model.Note;
import com.gfieast.akademia.representation.NoteRepresentation;

import static com.gfieast.akademia.util.DateTimeUtil.toLocalDateTime;

public class NoteToRepresentation {

    private NoteToRepresentation() {
    }

    public static NoteRepresentation convert(Note source) {
        return NoteRepresentation.builder()
                .id(source.getId())
                .title(source.getTitle())
                .text(source.getText())
                .importance(source.getImportance())
                .creationDate(toLocalDateTime(source.getCreationDate()))
                .modificationDate(toLocalDateTime(source.getModificationDate()))
                .build();
    }
}
