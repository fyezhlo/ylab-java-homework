package com.ylab.homework.hw2.stats;

public class StatsAccumulatorImpl implements StatsAccumulator{
    private int count;
    private int min;
    private int max;
    private double avg;
    private int sum;

    public StatsAccumulatorImpl() {
        this.count = 0;
        this.sum = 0;
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
        this.avg = 0.0;
    }

    @Override
    public void add(int value) {
        this.count++;
        setMin(value);
        setMax(value);
        this.sum += value;
        setAvg();
    }

    @Override
    public int getMin() {
        return this.min;
    }

    @Override
    public int getMax() {
        return this.max;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public double getAvg() {
        return this.avg;
    }

    public void setMin(int value) {
        if (this.min > value)
            this.min = value;
    }

    public void setMax(int value) {
        if (this.max < value)
            this.max = value;
    }

    public void setAvg() {
        this.avg = sum / count;
    }
}
