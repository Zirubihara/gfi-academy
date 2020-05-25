package com.gfieast.akademia.representation;

import java.util.List;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode
public class UserWithNotesRepresentation {

    private Long id;
    private String login;
    private String fullName;
    private List<NoteRepresentation> notes;
}
