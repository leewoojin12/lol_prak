package com.lol_park.exception;

public class PasswordMismatchException  extends RuntimeException {
    public PasswordMismatchException(String message) {
        super(message);
    }
}
