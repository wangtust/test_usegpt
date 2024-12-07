package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void testEmployeeConstructor() {
        Employee employee = new Employee("001", "Alice", 1000);
        assertEquals("001", employee.getEmployeeId());
        assertEquals("Alice", employee.getName());
        assertEquals(1000, employee.getSalary(), 0.001);
    }

    @Test
    public void testGiveRaiseWithPositivePercentage() {
        Employee employee = new Employee("001", "Alice", 1000);
        employee.giveRaise(10); // 10% raise
        assertEquals(1100, employee.getSalary(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGiveRaiseWithNegativePercentage() {
        Employee employee = new Employee("001", "Alice", 1000);
        employee.giveRaise(-10); // should throw IllegalArgumentException
    }
    
    @Test
    public void testToString() {
        Employee employee = new Employee("001", "Alice", 1000);
        String expected = "Employee{employeeId='001', name='Alice', salary=1000.0}";
        assertEquals(expected, employee.toString());
    }
}