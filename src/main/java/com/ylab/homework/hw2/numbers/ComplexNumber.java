package com.ylab.homework.hw2.numbers;

public interface ComplexNumber {
    public ComplexNumber addition(ComplexNumber num);
    public ComplexNumber subtraction(ComplexNumber num);
    public ComplexNumber multiplication(ComplexNumber num);
    public double getModule();
    public double getReal();
    public double getImage();
}
