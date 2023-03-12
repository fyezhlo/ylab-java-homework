package com.ylab.homework.hw2.stats;

public interface StatsAccumulator {
    void add(int value);
    int getMin();
    int getMax();
    int getCount();
    double getAvg();
}
