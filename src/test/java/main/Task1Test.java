package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {

    @Test
    public void isPrime_shouldReturnTrue_whenNumberIsPrime() {

        assertTrue(main.Task1.isPrime(31));

    }

    @Test
    public void isPrime_shouldReturnFalse_whenNumberIsNotPrime() {

        assertFalse(main.Task1.isPrime(16));
    }
}
