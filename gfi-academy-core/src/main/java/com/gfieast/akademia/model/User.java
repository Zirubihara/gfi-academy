package com.gfieast.akademia.model;


import javax.persistence.*;

import lombok.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_TABLE")
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "USER_LOGIN", nullable = false, length = 50, unique = true)
    private String login;

    @Column(name = "FULLNAME", nullable = false, length = 200)
    private String fullName;
}
