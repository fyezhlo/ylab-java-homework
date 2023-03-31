package com.ylab.homework.hw3.passwordValidator;

public class WrongLoginException extends Exception {
    public WrongLoginException() {}
    public WrongLoginException(String message) {
        super(message);
    }
}
