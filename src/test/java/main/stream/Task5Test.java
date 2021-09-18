package main.stream;

import main.stream.Task5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {

    @Test
    public void sumOfOddNumbersInRange_shouldReturnSumOfRangeOddNumbersInclusively_always() {
        final long start = 844;
        final long end = 847;
        final long expected = 845 + 847;

        assertEquals(expected, Task5.sumOfOddNumbersInRange(start, end));
    }

    @Test
    public void sumOfOddNumbersInRange_shouldReturnZero_whenRangeIsTooSmall() {
        final long start = 0;
        final long end = 0;
        final long expected = 0;

        assertEquals(expected, Task5.sumOfOddNumbersInRange(start, end));
    }
}
