package main;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1Test {

    @Test
    public void isPrime_shouldReturnTrue_whenNumberIsPrime() {

        Assert.assertTrue(Task1.isPrime(31));
    }

    @Test
    public void isPrime_shouldReturnFalse_whenNumberIsNotPrime() {

        Assert.assertFalse(Task1.isPrime(16));
    }
}
