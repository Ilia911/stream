package main.stream;

import main.stream.Task2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    public void createBadWordsDetectingStream_shouldReturnStreamOfBadWords_always() {

        String text = "a number by which another number is to be divided.";
        List<String> badWords = Arrays.asList("number", "is");
        final List<String> expected = badWords.stream().distinct().sorted().collect(Collectors.toList());

        assertEquals(expected,
                Task2.createBadWordsDetectingStream(text, badWords).collect(Collectors.toList()));
    }
}
