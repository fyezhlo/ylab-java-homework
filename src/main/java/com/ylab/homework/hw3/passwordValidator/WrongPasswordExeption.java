package com.ylab.homework.hw3.passwordValidator;

public class WrongPasswordExeption extends Exception{
    public WrongPasswordExeption() {}
    public WrongPasswordExeption(String message) {
        super(message);
    }
}
