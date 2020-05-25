package com.gfieast.akademia.representation;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gfieast.akademia.model.Importance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class NoteRepresentation {

    private Long id;
    private String title;
    private Importance importance;
    private String text;
    @JsonIgnore
    private LocalDateTime creationDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modificationDate;
}
