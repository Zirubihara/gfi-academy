package com.gfieast.akademia.converter;

import com.gfieast.akademia.model.User;
import com.gfieast.akademia.representation.UserWithNotesRepresentation;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class UserToUserWithNoteRepresentation {

    private UserToUserWithNoteRepresentation() {
    }

    public static UserWithNotesRepresentation convert(User source) {
        MapperFacade mapper = new DefaultMapperFactory.Builder().build().getMapperFacade();
        return mapper.map(source, UserWithNotesRepresentation.class);
    }
}
