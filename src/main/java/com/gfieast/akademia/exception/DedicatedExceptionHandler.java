package com.gfieast.akademia.exception;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class DedicatedExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleGenericException(
            HttpServletRequest request, UserNotFoundException exception) {
        log.warn("Request URI: {}", request.getRequestURI());
        log.warn("Exception message: {}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}
