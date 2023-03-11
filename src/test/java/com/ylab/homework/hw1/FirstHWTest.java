package com.ylab.homework.hw1;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

public class FirstHWTest {
    //Stars
    @Test
    public void printFigureTest() {
        assertEquals("", Stars.getFigure(0, 0, "*"));
        assertEquals("\n", Stars.getFigure(1, 0, "*"));
        assertEquals("", Stars.getFigure(0, 1, "*"));

        assertEquals("*  \n", Stars.getFigure(1, 1, "*"));
        assertEquals("*  *  *  \n*  *  *  \n", Stars.getFigure(2, 3, "*"));
    }

    //Pell
    @Test
    public void printPellNumberTest() {
        assertEquals(Pell.getPellNumber(0), 0);
        assertEquals(Pell.getPellNumber(1), 1);
        assertEquals(Pell.getPellNumber(5), 29);
        assertEquals(Pell.getPellNumber(-1), -1);
        assertEquals(Pell.getPellNumber(31), -1);
    }

}
