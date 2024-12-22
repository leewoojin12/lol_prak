package com.lol_park.exception;

public class InvalidPasswordException  extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
