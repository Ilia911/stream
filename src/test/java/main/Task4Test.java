package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {

    @Test
    public void factorial_shouldReturnFactorialOfGivenNumber_whenNumberMoreThenZero() {
        final long number = 6;
        final long expected = 2 * 3 * 4 * 5 * 6;

        assertEquals(expected, Task4.factorial(number));
    }

    @Test
    public void factorial_shouldReturnOne_whenNumberIsZero() {
        final long number = 0;
        final long expected = 1;

        assertEquals(expected, Task4.factorial(number));
    }
}
