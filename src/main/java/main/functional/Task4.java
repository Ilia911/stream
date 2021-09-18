package main.functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Write a collector that evaluates the product of squares of integer numbers in a Stream<Integer>.
 * <p>
 * Important. You should write only the collector in any valid formats but without ; on the end.
 * It will be passed as an argument to the collect() method of a stream as shown below.
 */
public class Task4 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        long val = numbers.stream() //write collector
        .collect(Collectors.mapping(x -> x * x, Collectors.reducing(1, (a, b) -> a * b)));

        System.out.println(val);

    }


}