package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {

    @Test
    public void calcSumOfCanceledTransOnNonEmptyAccounts_shouldReturnSum_always() {

        final long expected = 10000L;
        final String jsonString1 = "{ \"number\": \"1001\", \"balance\": 0, \"transactions\": [ { \"uuid\": " +
                "\"774cedda-9cde-4f53-8bc2-5b4d4859772a\", \"state\": \"CANCELED\", \"sum\": 1000, \"created\": " +
                "\"2016-12-12\" } ] }";
        final String jsonString2 = "{ \"number\": \"1002\", \"balance\": 8000, \"transactions\": [ { \"uuid\": " +
                "\"337868a7-f469-43c0-9042-3422ce37ee26a\", \"state\": \"FINISHED\", \"sum\": 8000, \"created\": " +
                "\"2016-12-12\" }, { \"uuid\": \"f8047f86-89e7-4226-8b75-74c55a4d7e31\", \"state\": " +
                "\"CANCELED\", \"sum\": 10000, \"created\": \"2016-12-12\" } ] }";

        assertEquals(expected, Task7.calcSumOfCanceledTransOnNonEmptyAccounts(
                (Task7.hardcoreInputData(jsonString1, jsonString2))));
    }
}
