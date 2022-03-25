package ua.com.foxminded.main;

import java.util.Map;

abstract class CharCounterDecorator implements CharCounter {
    private CharCounter countChar;

    public CharCounterDecorator(CharCounter countChar) {
        this.countChar = countChar;
    }

    public Map<Character, Long> countChars(String text) {
        return countChar.countChars(text);
    }

}