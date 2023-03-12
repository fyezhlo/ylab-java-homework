package com.ylab.homework.hw2.printer;

import java.time.Instant;

public class RateLimitedPrinterTest {
    public static void main(String[] args) {
        RateLimitedPrinter rateLimitedPrinter = new RateLimitedPrinter(1000);

        for (int i = 0; i < 1_000_000_000; i++) {
            rateLimitedPrinter.print(Instant.now().toString());
        }
    }
}
