package ua.com.foxminded.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UniqueCharCounterTest {
    private static final String ONLY_NULL = "String is null";
    private static final String TEXT = "Hello";
    private UniqueCharCounter charCounter;

    Map<Character, Long> prepareTestUniqueCharCounter() {
        Map<Character, Long> map = new LinkedHashMap<>();
        map.putIfAbsent('H', 1L);
        map.putIfAbsent('e', 1L);
        map.putIfAbsent('l', 2L);
        map.putIfAbsent('o', 1L);
        return map;
    }

    @BeforeEach
    public void init() {
        charCounter = new UniqueCharCounter();
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenInputNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> charCounter.countChars(null));
        assertEquals(ONLY_NULL, exception.getMessage());
    }

    @Test
    void shouldOutputWhenStringIsPassed() {
        Map<Character, Long> actual = charCounter.countChars(TEXT);
        Map<Character, Long> expected = prepareTestUniqueCharCounter();
        assertEquals(expected, actual);
    }
}