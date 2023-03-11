package com.ylab.homework.hw1;

import java.util.Scanner;

public class Stars {
    public static String getFigure(int rows, int cols, String symbol) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(symbol);
                sb.append("  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("введите количество строк: ");
        int rows = scanner.nextInt();

        System.out.print("введите количество столбцов: ");
        int cols = scanner.nextInt();

        System.out.print("введите символ: ");
        String symbol = scanner.next();

        System.out.println(Stars.getFigure(rows, cols, symbol));;
        scanner.close();
    }
}
