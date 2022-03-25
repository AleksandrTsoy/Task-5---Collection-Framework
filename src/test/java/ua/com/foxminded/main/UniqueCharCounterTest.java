package ua.com.foxminded.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UniqueCharCounterTest {
    private static final String ONLY_NULL = "String is null";
    private static final String TEXT = "Hello";
    private UniqueCharCounter charCounter;

    Map<Character, Long> prepareTestUniqueCharCounter() {
        List<Character> result = new ArrayList<>();
        result.add('H');
        result.add('e');
        result.add('l');
        result.add('l');
        result.add('o');
        Map<Character, Long> counted = result.stream()
                .collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()));
        return counted;
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