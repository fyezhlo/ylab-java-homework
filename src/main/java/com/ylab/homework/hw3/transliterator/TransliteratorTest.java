package com.ylab.homework.hw3.transliterator;

import com.ylab.homework.hw3.transliterator.Transliterator;
import com.ylab.homework.hw3.transliterator.TransliteratorImpl;

public class TransliteratorTest {
    public static void main(String[] args) {
        Transliterator transliterator = new TransliteratorImpl();
        String res = transliterator
                .transliterate("HELLO! ПРИВЕТ! Go, boy!");
        System.out.println(res);
    }
}
