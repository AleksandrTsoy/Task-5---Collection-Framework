package ua.com.foxminded.main;

import java.util.HashMap;
import java.util.Map;

public class CachedCharCounter extends CharCounterDecorator {
    private Map<String, Map<Character, Long>> cash = new HashMap<>();

    public CachedCharCounter(CharCounter countChar) {
        super(countChar);
    }

    public Map<Character, Long> countChars(String text) {
        return cash.computeIfAbsent(text, super::countChars);
    }
}
