package com.uyghur.java.dockerdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "username not found in database!")
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String name) {
        super(String.format("username %s not found . ", name));
    }
}
