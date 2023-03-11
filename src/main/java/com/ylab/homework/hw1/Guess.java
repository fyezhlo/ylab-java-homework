package com.ylab.homework.hw1;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Guess {
    public static void guessNumber() {
        int restOfAttempts = 10;
        int randomNumber = new Random().nextInt(100);

        Scanner scanner = new Scanner(System.in);
        int numberToCheck;

        System.out.println("Я загадал число от 1 до 99. У тебя "
                + restOfAttempts + " попыток отгадать. \nВведи число:" );

        while (restOfAttempts != 0) {
            numberToCheck = scanner.nextInt();
            restOfAttempts--;

            if (numberToCheck > randomNumber) {
                System.out.println("Мое число меньше! У тебя осталось "
                        + restOfAttempts + " попыток");
            } else if (numberToCheck < randomNumber) {
                System.out.println("Мое число больше! У тебя осталось "
                        + restOfAttempts + " попыток");
            } else {
                System.out.println("Ты угадал с "
                        + (10 - restOfAttempts) + " попытки");
                break;
            }

        }

        if (restOfAttempts == 0) {
            System.out.println("Ты не угадал");
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Guess.guessNumber();
    }
}
