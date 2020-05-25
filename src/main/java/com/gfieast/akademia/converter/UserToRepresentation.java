package com.gfieast.akademia.converter;

import com.gfieast.akademia.model.User;
import com.gfieast.akademia.representation.UserRepresentation;

public class UserToRepresentation {

    private UserToRepresentation() {}

    public static UserRepresentation convert(User source) {
        return UserRepresentation.builder()
                .id(source.getId())
                .login(source.getLogin())
                .fullName(source.getFullName())
                .build();
    }
}
