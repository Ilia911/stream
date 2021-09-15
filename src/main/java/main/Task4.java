package main;

import java.util.stream.LongStream;

/**
 * Many java developers wrote methods to calculate a factorial value using a
 * recursive or iterative algorithm. It's time to do it with streams.
 * <p>
 * The factorial of n is calculated by the product of integer number from 1 to n (inclusive).
 * The factorial of 0 is equal to 1.
 * <p>
 * Important. Use the given template for your factorial method.
 * Pay attention to type of an argument and the returned value. Please, don't use cycles or recursion.
 * <p>
 * Sample Input 1:
 * 0
 * <p>
 * Sample Output 1:
 * 1
 * <p>
 * Sample Input 2:
 * 1
 * <p>
 * Sample Output 2:
 * 1
 * <p>
 * Sample Input 3:
 * 2
 * <p>
 * Sample Output 3:
 * 2
 */
public class Task4 {
    /**
     * Calculates the factorial of the given number n
     *
     * @param n >= 0
     * @return factorial value
     */
    public static long factorial(long n) {
        //TODO Write your code here

        return LongStream.rangeClosed(1, n).reduce(1, (long number1, long number2) -> number1 * number2);
    }
}
