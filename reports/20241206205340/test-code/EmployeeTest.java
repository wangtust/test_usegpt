package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void testEmployeeConstructor() {
        Employee employee = new Employee("001", "Alice", 50000.0);
        assertEquals("001", employee.getEmployeeId());
        assertEquals("Alice", employee.getName());
        assertEquals(50000.0, employee.getSalary(), 0.001);
    }

    @Test
    public void testGiveRaiseWithPositivePercentage() {
        Employee employee = new Employee("001", "Alice", 50000.0);
        employee.giveRaise(10.0);
        assertEquals(55000.0, employee.getSalary(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGiveRaiseWithNegativePercentage() {
        Employee employee = new Employee("001", "Alice", 50000.0);
        employee.giveRaise(-10.0);
    }

    @Test
    public void testToString() {
        Employee employee = new Employee("001", "Alice", 50000.0);
        assertEquals("Employee{employeeId='001', name='Alice', salary=50000.0}", employee.toString());
    }

    // 可以继续编写更多的测试方法以增加代码覆盖率

}