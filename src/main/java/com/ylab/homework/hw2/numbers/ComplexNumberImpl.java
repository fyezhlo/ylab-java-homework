package com.ylab.homework.hw2.numbers;

public class ComplexNumberImpl implements ComplexNumber{
    private double realPart;
    private double imagePart;

    public ComplexNumberImpl(double realPart) {
        this.realPart = realPart;
        this.imagePart = 0.0;
    }

    public ComplexNumberImpl(double realPart, double imagePart) {
        this.realPart = realPart;
        this.imagePart = imagePart;
    }

    @Override
    public ComplexNumber addition(ComplexNumber num) {
        return new ComplexNumberImpl(
                this.realPart + num.getReal(),
                this.imagePart + num.getImage()
        );
    }

    @Override
    public ComplexNumber subtraction(ComplexNumber num) {
        return new ComplexNumberImpl(
                this.realPart - num.getReal(),
                this.imagePart - num.getImage()
        );
    }

    @Override
    public ComplexNumber multiplication(ComplexNumber num) {
        return new ComplexNumberImpl(
                this.realPart * num.getReal()
                        - this.imagePart * num.getImage(),
                this.realPart * num.getImage()
                        + this.imagePart * num.getReal()
        );
    }

    @Override
    public double getModulus() {
        return Math.sqrt(
                this.getReal() * this.getReal()
                        +
                this.getImage() * this.getImage()
        );
    }

    @Override
    public double getReal() {
        return this.realPart;
    }

    @Override
    public double getImage() {
        return this.imagePart;
    }

    @Override
    public String toString() {
        return getImage() == 0.0 ?
                String.format("(%.1f) + (i)", getReal()) :
                String.format("(%.1f) + (%.1fi)", getReal(), getImage());
    }
}
