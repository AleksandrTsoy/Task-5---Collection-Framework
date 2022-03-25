package ua.com.foxminded.main;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class UniqueCharCounter implements CharCounter {

    public Map<Character, Long> countChars(String text) throws IllegalArgumentException {

        if (text == null) {
            throw new IllegalArgumentException("String is null");
        }
        return text.chars().mapToObj(ch -> (char) ch).collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()));

    }

}
