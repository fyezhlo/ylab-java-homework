package com.ylab.homework.hw3.datedMap;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DatedMapTest {
    public static void main(String[] args) throws InterruptedException {
        DatedMap datedMap = new DatedMapImpl();
        datedMap.put("1", "1");
        TimeUnit.SECONDS.sleep(1);

        datedMap.put("2", "2");
        TimeUnit.SECONDS.sleep(1);

        System.out.println(
                "1: " + datedMap.getKeyLastInsertionDate("1")
                + "\n2: " + datedMap.getKeyLastInsertionDate("2")
                + "\ncurr time: " + new Date()
        );

        datedMap.put("1", "11");
        TimeUnit.SECONDS.sleep(1);

        System.out.println(
                "\nnew iteration with 1: " + datedMap.getKeyLastInsertionDate("1")
                + "\ncurr time: " + new Date()
        );
    }
}
