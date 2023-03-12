package com.ylab.homework.hw2;

import com.ylab.homework.hw2.numbers.ComplexNumber;
import com.ylab.homework.hw2.numbers.ComplexNumberImpl;
import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SecondHWTest {
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void complexNumbersTest() {
        ComplexNumber num1 = new ComplexNumberImpl(33.4, 12.6);
        ComplexNumber num2 = new ComplexNumberImpl(51.6, 12.9);

        assertEquals("(85.0) + (25.5i)", num1.addition(num2).toString());
        assertEquals("(-18.2) + (-0.3i)", num1.subtraction(num2).toString());
        assertEquals("(1560.9) + (1081.0i)", num1.multiplication(num2).toString());

        DecimalFormat df = new DecimalFormat("###.###");
        assertEquals("35.698", df.format(num1.getModulus()));
    }
}
