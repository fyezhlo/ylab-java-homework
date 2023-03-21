package com.ylab.homework.hw3.fileSort;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

public class Test {
    public static void main(String[] args) throws IOException {
        File dataFile = new Generator().generate("data.txt", 375_000_000);
        System.out.println(new Validator(dataFile).isSorted()); // false

        System.out.println("start of sorting: " + Instant.now());
        File sortedFile = new Sorter().sortFile(dataFile);
        System.out.println("end of sorting: " + Instant.now());
        System.out.println("is valid? : " + new Validator(sortedFile).isSorted()); // true
    }
}
