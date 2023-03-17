package com.ylab.homework.hw2.sequences;

import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SequencesImpl implements Sequences {
    @Override
    public void a(int n) {
        int base = 2;
        int step = 2;

        System.out.print("A. ");
        for (int i = 1; i <= n; i++)
            System.out.print(base + step * (i-1) + ", ");
        System.out.println();
    }

    @Override
    public void b(int n) {
        int base = 1;
        int step = 2;

        System.out.print("B. ");
        for (int i = 1; i <= n; i++)
            System.out.print(base + step * (i-1) + ", ");
        System.out.println();
    }

    @Override
    public void c(int n) {
//        приходится часто оборачивать примитывы в объекты,
//                поэтому лучше так не делать
       /* printSequence("C", n,
                i -> System.out.print((Integer) i * (Integer) i + ", "));*/

        System.out.print("C. ");
        for (int i = 1; i <= n; i++)
            System.out.print(i * i + ", ");
        System.out.println();
    }

    @Override
    public void d(int n) {
        System.out.print("D. ");
        for (int i = 1; i <= n; i++)
            System.out.print(i * i * i + ", ");
        System.out.println();    }

    @Override
    public void e(int n) {
        System.out.print("E. ");
        for (int i = 1; i <= n; i++)
            System.out.print((int)Math.pow(-1, (i+1) % 2) + ", ");
        System.out.println();
    }

    @Override
    public void f(int n) {
        System.out.print("F. ");
        for (int i = 1; i <= n; i++)
            System.out.print((int)Math.pow(-1, (i+1) % 2) * i + ", ");
        System.out.println();
    }

    @Override
    public void g(int n) {
        System.out.print("G. ");
        for (int i = 1; i <= n; i++)
            System.out.print((int)Math.pow(-1, (i+1) % 2) * i * i + ", ");
        System.out.println();
    }

    @Override
    public void h(int n) {
        System.out.print("H. ");
        int num = 1;
        for (int i = 1; i <= n; i++){
            if (i % 2 == 1) {
                System.out.print(num++ + ", ");
            } else System.out.print(0 + ", ");
        }

        System.out.println();
    }

    @Override
    public void i(int n) {
        System.out.print("I. ");
        int[] arr = new int[]{1, 1};
        for (int i = 1; i <=n; i++) {
            arr = new int[] {arr[1], arr[1] * i};
            System.out.print(arr[1] + ", ");
        }
        System.out.println();
    }

    @Override
    public void j(int n) {
        System.out.print("J. ");
        Stream.iterate(new int[]{0, 1}, t -> new int[] {t[1], t[1] + t[0]})
                .mapToInt(t -> t[1])
                .limit(n)
                .forEach(t -> System.out.print(t + ", "));
    }

    //experimental method
    private void printSequence(String seqName, int n, Consumer consumer) {
        System.out.print(seqName + ". ");
        for (Integer i = 1; i <= n; i++)
            consumer.accept(i);
        System.out.println();
    }
}
