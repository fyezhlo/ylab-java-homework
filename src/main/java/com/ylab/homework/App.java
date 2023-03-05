package com.ylab.homework;

import com.ylab.homework.hw1.Stars;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        //Stars
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

        //
    }
}
