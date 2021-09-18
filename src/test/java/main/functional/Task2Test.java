package main.functional;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void disjunctAll_resultPredicateShouldReturnTrue_whenInputDataValid() {

        IntPredicate resultPredicate;
        List<IntPredicate> predicateList = new ArrayList<>();

        IntPredicate predicate1 = x -> x % 2 == 0;
        IntPredicate predicate2 = x -> x % 3 == 0;

        predicateList.add(predicate1);
        predicateList.add(predicate2);

        resultPredicate = Task2.disjunctAll(predicateList);
        assertTrue(resultPredicate.test(6));
    }

    @Test
    void disjunctAll_resultPredicateShouldReturnFalse_always() {

        IntPredicate resultPredicate;
        List<IntPredicate> predicateList = new ArrayList<>();

        resultPredicate = Task2.disjunctAll(predicateList);
        assertFalse(resultPredicate.test(6));
    }
}