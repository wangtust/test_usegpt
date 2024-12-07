package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void testConstructor() {
        Employee emp = new Employee("001", "John Doe", 50000.0);

        assertEquals("001", emp.getEmployeeId());
        assertEquals("John Doe", emp.getName());
        assertEquals(50000.0, emp.getSalary(), 0.001);
    }

    @Test
    public void testGiveRaiseWithPositivePercentage() {
        Employee emp = new Employee("001", "John Doe", 50000.0);
        emp.giveRaise(10.0);

        assertEquals(55000.0, emp.getSalary(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGiveRaiseWithNegativePercentage() {
        Employee emp = new Employee("001", "John Doe", 50000.0);
        emp.giveRaise(-10.0);
    }

    @Test
    public void testToString() {
        Employee emp = new Employee("001", "John Doe", 50000.0);

        assertEquals("Employee{employeeId='001', name='John Doe', salary=50000.0}", emp.toString());
    }
}