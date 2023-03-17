package com.ylab.homework.hw2.snils;

public class SnilsValidatorTest {
    public static void main(String[] args) {
        SnilsValidator snilsValidator = new SnilsValidatorImpl();
        String snils = "90114404441";

        System.out.println(snilsValidator.validate(snils));;
    }
}
