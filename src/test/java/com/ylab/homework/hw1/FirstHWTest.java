package com.ylab.homework.hw1;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

public class FirstHWTest {
    //Stars
    @Test
    public void printFigureTest() {
        Stars.printFigure(2, 3, "*");
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

    //MultTable
    @Test
    public void printMultTableTest() {
        MultTable.printMultTable();
    }

    //Guess
    @Test
    public void guessNumberTest() {
        int randomNumber = ThreadLocalRandom.current().nextInt(99,100);
        System.out.println(randomNumber);
    }

}
