package com.gfieast.akademia.exception;

import static java.lang.String.format;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long userId) {
        super(format("User with id %s not found", userId));
    }
}
