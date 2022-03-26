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

    @InjectMocks
    private CachedCharCounter charCounter;

    @Mock
    UniqueCharCounter uniqueCharCounterMock;

    @Test
    void cashedCharCounterTest() {
        charCounter.countChars(TEXT);
        charCounter.countChars(TEXT);
        verify(uniqueCharCounterMock).countChars(TEXT);
        verifyNoMoreInteractions(uniqueCharCounterMock);
    }
}