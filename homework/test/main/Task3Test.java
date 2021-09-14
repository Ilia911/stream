package main;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task3Test {

    @Test
    public void createFilteringStream_shouldReturnIntStream_always() {

        IntStream evenStream = Stream.of("2", "4", "6", "30", "60").mapToInt(Integer::valueOf);
        IntStream oddStream = Stream.of("45", "9", "15", "11").mapToInt(Integer::valueOf);

        List<Integer> expected = Arrays.asList(45, 60);

        Assert.assertEquals(expected, Task3.createFilteringStream(evenStream, oddStream).boxed().collect(Collectors.toList()));

    }
}
