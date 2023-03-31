package com.ylab.homework.hw3.passwordValidator;

public class WrongPasswordException extends Exception{
    public WrongPasswordException() {}
    public WrongPasswordException(String message) {
        super(message);
    }
}
