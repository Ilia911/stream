package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {

    @Test
    public void calcNumberOfEmployees_ShouldReturnGeneralNumberOfEmployees_whenSalaryMoreThenThreshold()
            throws JsonProcessingException {

        final long expected = 1L;
        final String jsonString1 = "{ \"name\": \"dep-1\", \"code\": \"111-1\", \"employees\": [ { \"name\": " +
                "\"William\", \"salary\": 20000 }, { \"name\": \"Sophia\", \"salary\": 10000 } ] }";
        final String jsonString2 = "{ \"name\": \"dep-2\", \"code\": \"222-1\", \"employees\": " +
                "[ { \"name\": \"John\", \"salary\": 50000 } ] }";

        assertEquals(expected, Task6.calcNumberOfEmployees
                (Task6.hardcoreInputData(jsonString1, jsonString2), 20000L));
    }
}
