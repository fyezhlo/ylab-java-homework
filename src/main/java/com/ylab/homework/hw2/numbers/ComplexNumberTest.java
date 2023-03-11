package com.ylab.homework.hw2.numbers;

public class ComplexNumberTest {
    public static void main(String[] args) {
        ComplexNumberImpl num1 = new ComplexNumberImpl(33.4, 12.6);
        ComplexNumber num2 = new ComplexNumberImpl(51.6, 12.9);
        System.out.println("Complex number: " + num1);

        System.out.println("addition with " + num2 + ": " +
                num1.addition(num2)
        );

        System.out.println("subtraction with " + num2 + ": " +
                num1.subtraction(num2)
        );

        System.out.println("multiplication with " + num2 + ": " +
                num1.multiplication(num2)
        );

        System.out.println("module of " + num1 + ": " +
                num1.getModule()
        );
    }
}
