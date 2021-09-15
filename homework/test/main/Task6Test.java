package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task6Test {

    @Test
    public void calcNumberOfEmployees_ShouldReturnGeneralNumberOfEmployees_whenSalaryMoreThenThreshold()
            throws JsonProcessingException {

        final long expected = 1;

        Assert.assertEquals(expected, Task6.calcNumberOfEmployees(Task6.hardcoreInputData(), 20000));
    }
}
