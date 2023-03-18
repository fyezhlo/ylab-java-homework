package com.ylab.homework.hw3;

import com.ylab.homework.hw3.transliterator.Transliterator;
import com.ylab.homework.hw3.transliterator.TransliteratorImpl;
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
