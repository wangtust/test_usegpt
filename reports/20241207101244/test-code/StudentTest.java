package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class StudentTest {

    @Test
    public void testAddGrade() {
        Student student = new Student("12345", "Alice");
        student.addGrade(85.0);
        assertEquals(Arrays.asList(85.0), student.getGrades());
    }

    @Test
    public void testGetAverageGrade() {
        Student student = new Student("54321", "Bob");
        student.addGrade(90.0);
        student.addGrade(85.0);
        assertEquals(87.5, student.getAverageGrade(), 0.1);
    }

}