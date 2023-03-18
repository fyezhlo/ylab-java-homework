package com.ylab.homework.hw3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThirdHWTest {
    @Test
    public void transliteratorTest() {
        Transliterator tra = new TransliteratorImpl();

        assertEquals("ZHEESHCHTS", tra.transliterate("ЖЕЁЩЦ"));
        assertEquals("рфува", tra.transliterate("рфува"));
    }
}
