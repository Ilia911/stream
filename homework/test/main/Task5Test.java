package main;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Task5Test {

    @Test
    public void sumOfOddNumbersInRange_shouldReturnSumOfRangeOddNumbersInclusively_always() {
        final long start = 844;
        final long end = 847;
        final long expected = 845 + 847;

        Assert.assertEquals(expected, Task5.sumOfOddNumbersInRange(start, end));
    }

    @Test
    public void sumOfOddNumbersInRange_shouldReturnZero_whenRangeIsTooSmall() {
        final long start = 0;
        final long end = 0;
        final long expected = 0;

        Assert.assertEquals(expected, Task5.sumOfOddNumbersInRange(start, end));
    }
}
