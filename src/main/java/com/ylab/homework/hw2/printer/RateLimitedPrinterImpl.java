package com.ylab.homework.hw2.printer;

public class RateLimitedPrinterImpl implements RateLimitedPrinter {

    private int interval;
    private long lastPrintTime;
    public RateLimitedPrinterImpl(int interval) {
        this.interval = interval;
    }

    @Override
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
