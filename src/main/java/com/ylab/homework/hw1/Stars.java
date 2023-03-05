package com.ylab.homework.hw1;

import java.util.Scanner;

public class Stars {
    public static void printFigure(int rows, int cols, String symbol) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(symbol + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("введите количество строк: ");
            int rows = scanner.nextInt();

            System.out.print("введите количество столбцов: ");
            int cols = scanner.nextInt();

            System.out.print("введите символ: ");
            String symbol = scanner.next();

            Stars.printFigure(rows, cols, symbol);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
