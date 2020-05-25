package com.gfieast.akademia.model;

import java.time.Instant;
import javax.persistence.*;

import lombok.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "NOTE")
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "note_seq")
    @SequenceGenerator(name = "note_seq", sequenceName = "note_seq", allocationSize = 1)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "IMPORTANCE", nullable = false)
    @Enumerated(EnumType.STRING)
    private Importance importance;

    @Column(name = "TEXT", length = 4000)
    private String text;

    @Column(name = "CREATION_DATE", nullable = false)
    private Instant creationDate;

    @Column(name = "MODIFICATION_DATE", nullable = false)
    private Instant modificationDate;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
}
