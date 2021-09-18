package main.functional;

import java.util.Objects;

/**
 * You need to write your own functional interface (TernaryIntPredicate) and use it with a
 * lambda expression.
 * The interface must have a single non-static (and non-default) method test with
 * three int arguments that returns boolean value.
 * Besides, you need to write a lambda expression with three int arguments using your
 * TernaryIntPredicate.
 * <p>
 * The lambda expression has to return true if all passed values are different otherwise false. The name of the instance is allValuesAreDifferentPredicate. It should be a static field.
 * <p>
 * Sample Input 1:
 * 1 1 1
 * <p>
 * Sample Output 1:
 * False
 * <p>
 * Sample Input 2:
 * 2 3 4
 * <p>
 * Sample Output 2:
 * True
 */
public class Task1 {

    private static boolean allValuesAreDifferentPredicate;

    public static void main(String[] args) {
        //call function with your expression
        TernaryIntPredicate<Integer> compareThreeInts = ((int1, int2, int3)
                -> !Objects.equals(int1, int2) && !Objects.equals(int1, int3) && !Objects.equals(int3, int2));

        allValuesAreDifferentPredicate = compareThreeInts.test(1, 2, 30);
        System.out.println(allValuesAreDifferentPredicate);
    }
}

@FunctionalInterface
interface TernaryIntPredicate</*Write argument*/T> {
    // Write a method here
    boolean test(T int1, T int2, T int3);
}