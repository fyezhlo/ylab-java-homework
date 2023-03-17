package com.ylab.homework.hw2.sequences;

import java.util.Scanner;
import java.util.SortedMap;

public class SequencesTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sequences sequences = new SequencesImpl();
        System.out.print("enter n: ");
        int n = scanner.nextInt();
        if (n > 0) {
            sequences.a(n);
            sequences.b(n);
            sequences.c(n);
            sequences.d(n);
            sequences.e(n);
            sequences.f(n);
            sequences.g(n);
            sequences.h(n);
            sequences.i(n);
            sequences.j(n);
        } else System.out.println("n must be greater than 0");

    }
}
