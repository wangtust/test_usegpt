package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class StudentTest {

    @Test
    public void testAddGrade() {
        Student student = new Student("12345", "Alice");
        student.addGrade(85);
        List<Double> grades = student.getGrades();
        assertEquals(1, grades.size());
        assertEquals(85.0, grades.get(0), 0.001);
    }

    @Test
    public void testGetAverageGrade() {
        Student student = new Student("54321", "Bob");
        student.addGrade(90);
        student.addGrade(80);
        assertEquals(85.0, student.getAverageGrade(), 0.001);
    }

    // Add more test cases as needed

}