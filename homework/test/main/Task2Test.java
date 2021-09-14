package main;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2Test {

    @Test
    public void createBadWordsDetectingStream_shouldReturnStreamOfBadWords_always() {

        String text = "a number by which another number is to be divided.";
        List<String> badWords = Arrays.asList("number", "is");
        final List<String> expected = badWords.stream().distinct().sorted().collect(Collectors.toList());

        Assert.assertEquals(expected,
                Task2.createBadWordsDetectingStream(text, badWords).collect(Collectors.toList()));
    }
}
