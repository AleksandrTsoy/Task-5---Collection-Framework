package ua.com.foxminded.main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CachedCharCounterTest {
    private static final String TEXT = "Hello";
    private static final String WORD = "World";

    @InjectMocks
    private CachedCharCounter charCounter;

    @Mock
    UniqueCharCounter uniqueCharCounterMock;

    @Test
    void shouldOutputWhenSameStringIsPassedTwice() {
        charCounter.countChars(TEXT);
        charCounter.countChars(TEXT);
        verify(uniqueCharCounterMock).countChars(TEXT);
        verifyNoMoreInteractions(uniqueCharCounterMock);
    }

    @Test
    void shouldOutputWhenDifferentStringIsPassed() {
        charCounter.countChars(TEXT);
        charCounter.countChars(WORD);
        verify(uniqueCharCounterMock).countChars(TEXT);
        verify(uniqueCharCounterMock).countChars(WORD);
        verifyNoMoreInteractions(uniqueCharCounterMock);
    }
}