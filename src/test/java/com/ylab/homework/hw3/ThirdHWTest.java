package com.ylab.homework.hw3;

import com.ylab.homework.hw3.transliterator.Transliterator;
import com.ylab.homework.hw3.transliterator.TransliteratorImpl;
import org.junit.Test;

import static com.ylab.homework.hw3.passwordValidator.PasswordValidator.validate;
import static org.junit.Assert.*;

public class ThirdHWTest {
    @Test
    public void transliteratorTest() {
        Transliterator tra = new TransliteratorImpl();

        assertEquals("ZHEESHCHTS", tra.transliterate("ЖЕЁЩЦ"));
        assertEquals("рфува", tra.transliterate("рфува"));
    }

    @Test
    public void validatorTest() {
        assertTrue(validate("123_abc_ABC", "", ""));
        assertFalse(validate("%&#123_abc_ABC", "", ""));
        assertFalse(validate("01234567890123456789", "", ""));

        assertTrue(validate("", "123_abc_ABC", "123_abc_ABC"));
        assertFalse(validate("", "123_abc_ABC", ""));
        assertFalse(validate("", "#$!123_abc_ABC", ""));
        assertFalse(validate("", "01234567890123456789", ""));
    }
}
