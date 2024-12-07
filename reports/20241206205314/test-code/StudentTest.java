package net.mooctest;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class StudentTest {

    private Student student;

    @Before
    public void setUp() {
        student = new Student("123456", "John Doe");
    }

    @Test
    public void testGetStudentId() {
        assertEquals("123456", student.getStudentId());
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", student.getName());
    }

    @Test
    public void testAddGrade() {
        student.addGrade(85);
        List<Double> grades = student.getGrades();
        assertEquals(1, grades.size());
        assertEquals(85.0, grades.get(0), 0.001);
    }

    @Test
    public void testAddGradeWithInvalidGrade() {
        try {
            student.addGrade(-5);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void testGetAverageGrade() {
        student.addGrade(90);
        student.addGrade(80);
        assertEquals(85.0, student.getAverageGrade(), 0.001);
    }

    @Test
    public void testGetAverageGradeWithNoGrades() {
        assertEquals(0, student.getAverageGrade(), 0.001);
    }

    @Test
    public void testToString() {
        String expected = "Student{studentId='123456', name='John Doe', grades=[]}";
        assertEquals(expected, student.toString());
    }
}