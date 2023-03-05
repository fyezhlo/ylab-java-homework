package com.ylab.homework.hw1;

public class Stars {
    public static void printFigure(int rows, int cols, String symbol) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(symbol + "  ");
            }
            System.out.println();
        }
    }
}
