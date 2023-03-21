package com.ylab.homework.hw3.passwordValidator;

public class WrongLoginExeption extends Exception {
    public WrongLoginExeption() {}
    public WrongLoginExeption(String message) {
        super(message);
    }
}
