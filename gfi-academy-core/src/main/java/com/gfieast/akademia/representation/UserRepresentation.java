package com.gfieast.akademia.representation;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode
public class UserRepresentation {

    private Long id;
    private String login;
    private String fullName;
}
