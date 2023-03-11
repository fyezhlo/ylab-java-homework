package com.ylab.homework.hw2.numbers;

public class ComplexNumberImpl implements ComplexNumber{
    private double realPart;
    private double mockPart;

    public ComplexNumberImpl(double realPart) {
        this.realPart = realPart;
    }

    public ComplexNumberImpl(double realPart, double mockPart) {
        this.realPart = realPart;
        this.mockPart = mockPart;
    }

    @Override
    public ComplexNumber addition(ComplexNumber complexNumber) {
        return null;
    }

    @Override
    public ComplexNumber subtraction(ComplexNumber complexNumber) {
        return null;
    }

    @Override
    public ComplexNumber multiplication(ComplexNumber complexNumber) {
        return null;
    }

    @Override
    public double getModule(ComplexNumber complexNumber) {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
