
package main.functional;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Write the disjunctAll method that accepts a list of
 * IntPredicate's and returns a single IntPredicate.
 * The result predicate is a disjunction of all input predicates.
 *
 * If the input list is empty then the result predicate should
 * return false for any integer value (always false).
 */
public class Task2 {

    /**
     * The method represents a disjunct operator for a list of predicates.
     * For an empty list it returns the always false predicate.
     */
    public static IntPredicate disjunctAll(List<IntPredicate> predicates) {

        //write code
        return predicates.stream()
                .reduce(IntPredicate::and)
                .orElse(value -> false);
    }
}