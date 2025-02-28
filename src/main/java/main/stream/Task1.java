package main.stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Write a method using Stream API to check the input number is prime or not.
 * Let's agree that input value is always greater than 1 (i.e. 2, 3, 4, 5, ....).
 * Use the provided template for your method.
 * <p>
 * A prime number is a value greater than 1 that has no positive divisors other than 1 and itself.
 * See https://en.wikipedia.org/wiki/Prime_number
 * <p>
 * Important. This problem has a simple and clear solution with streams.
 * Please, do not use cycles.
 * <p>
 * Sample Input 1:
 * 2
 * Sample Output 1:
 * True
 * <p>
 * Sample Input 2:
 * 3
 * Sample Output 2:
 * True
 * <p>
 * Sample Input 3:
 * 4
 * Sample Output 3:
 * False
 */
public class Task1 {
    /**
     * Checking if a number is prime
     *
     * @param number to test >= 2
     * @return true if number is prime else false
     */
    public static boolean isPrime(final long number) {
        //TODO Write your code here

        final Optional<Long> first = Stream.iterate(number - 1, n -> --n).filter(n -> number % n == 0).findFirst();

        return first.get() == 1;
    }
}
