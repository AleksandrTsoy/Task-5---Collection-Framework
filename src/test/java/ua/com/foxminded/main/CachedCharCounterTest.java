package ua.com.foxminded.main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CachedCharCounterTest {
    private static final String TEXT = "Hello";

    @InjectMocks
    private CachedCharCounter charCounter;

    @Mock
    UniqueCharCounter uniqueCharCounterMock;

    @Test
    void cashedCharCounterTest() {
        charCounter = new CachedCharCounter(uniqueCharCounterMock);
        Map<Character, Long> result = TEXT.chars().mapToObj(ch -> (char) ch).collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()));
        when(uniqueCharCounterMock.countChars(TEXT)).thenReturn(result);
        charCounter.countChars(TEXT);
        charCounter.countChars(TEXT);
        verify(uniqueCharCounterMock, atLeastOnce()).countChars(TEXT);
    }
}