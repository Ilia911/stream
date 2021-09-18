package main.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

/**
 * <p>
 * Write three functions:
 * <p>
 * Multifunctional mapper (transformer) that accepts a list of operators (mappers) and returns a new operator.
 * The returned operator accepts a list of integer numbers and sequentially applies each mapper to each number in
 * the list (performs multiple transformations). The result is a list with transformed values.
 * In terms of the multifunctional mapper define an operator that multiplies by two each integer number and then
 * add one to its. The operator is applied to each number in the input list.
 * In terms of the multifunctional mapper define an operator that squares each integer number and then calculates
 * the next even number following it. The operator is also applied to each number in the input list.
 * To simplify the problem all function (represented by objects) are declared, you need to finish their realization.
 * Look carefully at definition of each function.
 * Also there is an example: identity operation that is defined in terms of the multifunctional mapper.
 * It doesn't changes values in the input list. It repeats identity transformation three times just for example.
 * During testing all operators will be tested (including identity).
 * <p>
 * <p>
 * Example 1. The input list is [1, 1, 1, 1]
 * <p>
 * identityTransformation returns the list [1, 1, 1, 1]
 * multTwoAndThenAddOneTransformation returns the list [3, 3, 3, 3]
 * squareAndThenGetNextEvenNumberTransformation returns the list [2, 2, 2, 2]
 * <p>
 * Example 2. The input list is [1, 2, 3].
 * <p>
 * identityTransformation returns the list [1, 2, 3]
 * multTwoAndThenAddOneTransformation returns the list [3, 5, 7]
 * squareAndThenGetNextEvenNumberTransformation returns the result list [2, 6, 10]
 */
public class Task7 {

    public static void main(String[] args) {
        System.out.println(identityTransformation.apply(Arrays.asList(1, 1, 1)));
        System.out.println(identityTransformation.apply(Arrays.asList(1, 2, 3)));
        System.out.println(multTwoAndThenAddOneTransformation.apply(Arrays.asList(1, 1, 1)));
        System.out.println(multTwoAndThenAddOneTransformation.apply(Arrays.asList(1, 2, 3)));
        System.out.println(squareAndThenGetNextEvenNumberTransformation.apply(Arrays.asList(1, 1, 1)));
        System.out.println(squareAndThenGetNextEvenNumberTransformation.apply(Arrays.asList(1, 2, 3)));

        IntUnaryOperator intUnaryOperator1 = x -> x + 1;
        IntUnaryOperator intUnaryOperator2 = x -> x * 2;
        IntUnaryOperator intUnaryOperator3 = x -> x - 3;
        final List<IntUnaryOperator> intUnaryOperators = Arrays.asList(intUnaryOperator1, intUnaryOperator2, intUnaryOperator3);

        System.out.println(multifunctionalMapper.apply(intUnaryOperators).apply(Arrays.asList(1, 2, 3)));
    }

    /**
     * The function accepts a list of mappers and returns an operator that accepts a list of integers
     * and sequentially applies each mapper to each value (perform a transformation)
     */
    public static final Function<List<IntUnaryOperator>, UnaryOperator<List<Integer>>> multifunctionalMapper = //write code
            intUnaryOperatorList -> {
                final IntUnaryOperator resultIntUnaryOperator = intUnaryOperatorList.stream()
                        .reduce(IntUnaryOperator.identity(), (first, second) -> second.compose(first));

                UnaryOperator<List<Integer>> result = listInteger -> {
                    listInteger.replaceAll(resultIntUnaryOperator::applyAsInt);
                    return listInteger;
                };
                return result;
            };


    /**
     * EXAMPLE: the operator transforms each number to the same number (perform the identity transformation)
     * <p>
     * It returns a list of the same numbers.
     */
    public static final UnaryOperator<List<Integer>> identityTransformation = //write code
            list -> {
                list.replaceAll(x -> x);
                return list;
            };

    /**
     * The operator accepts an integer list.
     * It multiplies by two each integer number and then add one to its.
     * <p>
     * The operator returns transformed integer list.
     */
    public static final UnaryOperator<List<Integer>> multTwoAndThenAddOneTransformation = //write code

            list -> {
                list.replaceAll(x -> x * 2 + 1);
                return list;
            };
    /**
     * The operator accepts an integer list.
     * It squares each integer number and then get the next even number following it.
     * <p>
     * The operator returns transformed integer list.
     */
    public static final UnaryOperator<List<Integer>> squareAndThenGetNextEvenNumberTransformation = //write code
            list -> {
                list.replaceAll(x -> {
                            int i = x * x;
                            return i % 2 == 0 ? i + 2 : i + 1;
                        }
                );
                return list;
            };
}