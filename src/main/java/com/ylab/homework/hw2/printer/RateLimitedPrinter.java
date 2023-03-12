package com.ylab.homework.hw2.printer;

public class RateLimitedPrinter {

    private int interval;
    private long lastPrintTime;
    public RateLimitedPrinter(int interval) {
        this.interval = interval;
    }

    public void print(String message) {
        if (System.currentTimeMillis() - lastPrintTime >= interval) {
            System.out.println(message);
            setLastPrintTime();
        }
    }

    private void setLastPrintTime() {
        this.lastPrintTime = System.currentTimeMillis();
    }
}
