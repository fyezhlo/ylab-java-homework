package com.ylab.homework.hw3.transliterator;

import com.ylab.homework.hw3.transliterator.Transliterator;

import java.util.HashMap;
import java.util.Map;

public class TransliteratorImpl implements Transliterator {

    private final Map<Character, String> translitMap;

    public TransliteratorImpl() {
        this.translitMap = getTranslitMap();
    }

    private Map<Character, String> getTranslitMap() {
        Map<Character, String> translitMap = new HashMap<>(33);
        {
            translitMap.put('А', "A");
            translitMap.put('Б', "B");
            translitMap.put('В', "V");
            translitMap.put('Г', "G");
            translitMap.put('Д', "D");
            translitMap.put('Е', "E");
            translitMap.put('Ё', "E");
            translitMap.put('Ж', "ZH");
            translitMap.put('З', "Z");
            translitMap.put('И', "I");
            translitMap.put('Й', "I");
            translitMap.put('К', "K");
            translitMap.put('Л', "L");
            translitMap.put('М', "M");
            translitMap.put('Н', "N");
            translitMap.put('О', "O");
            translitMap.put('П', "P");
            translitMap.put('Р', "R");
            translitMap.put('С', "S");
            translitMap.put('Т', "T");
            translitMap.put('У', "U");
            translitMap.put('Ф', "F");
            translitMap.put('Х', "KH");
            translitMap.put('Ц', "TS");
            translitMap.put('Ч', "CH");
            translitMap.put('Ш', "SH");
            translitMap.put('Щ', "SHCH");
            translitMap.put('Ы', "Y");
            translitMap.put('Ь', "");
            translitMap.put('Ъ', "IE");
            translitMap.put('Э', "E");
            translitMap.put('Ю', "IU");
            translitMap.put('Я', "IA");
        }
        return translitMap;
    }
    @Override
    public String transliterate(String source) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char currentChar = source.charAt(i);
            stringBuilder.append(
                    translitMap.getOrDefault(
                            currentChar,
                            String.valueOf(currentChar)
                    )
            );
        }

        return stringBuilder.toString();
    }
}
