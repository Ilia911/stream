package main;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {

    @Test
    public void calcNumberOfEmployees_ShouldReturnGeneralNumberOfEmployees_whenSalaryMoreThenThreshold() {

        final long expected = 1L;

        assertEquals(expected, Task6.calcNumberOfEmployees
                (hardcoreDepartments(), 20000L));
    }

    private List<Department> hardcoreDepartments() {

        final Employee william = new Employee("William", 20000L);
        final Employee sophia = new Employee("Sophia", 10000L);
        final Employee john = new Employee("John", 50000L);

        final List<Employee> employeesDepartment1 = new ArrayList<>();
        employeesDepartment1.add(william);
        employeesDepartment1.add(sophia);

        final List<Employee> employeesDepartment2 = new ArrayList<>();
        employeesDepartment2.add(john);

        final Department department = new Department("dep-1", "111-1", employeesDepartment1);
        final Department department2 = new Department("dep-2", "222-1", employeesDepartment2);

        final List<Department> departments = new ArrayList<>();

        departments.add(department);
        departments.add(department2);

        return departments;
    }
}
