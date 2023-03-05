package com.ylab.homework.hw1;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Guess {
    public static void guessNumber() throws Exception{
        int restOfAttempts = 10;
        int randomNumber = ThreadLocalRandom
                .current()
                .nextInt(0,100);

        Scanner scanner = new Scanner(System.in);
        int numberToCheck;
        boolean isGuessed = false;

        while (restOfAttempts != 0) {
            System.out.println("введите число: ");
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
                isGuessed = true;
                break;
            }

        }

        if (!isGuessed) {
            System.out.println("Ты не угадал");
        }
    }

    public static void main(String[] args) {
        try {
            Guess.guessNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
