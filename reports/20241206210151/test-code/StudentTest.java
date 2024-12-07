package net.mooctest;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.*;

public class StudentTest {

    private Student student;

    @Before
    public void setUp() {
        student = new Student("12345", "Alice");
    }

    @Test
    public void testGetStudentId() {
        assertEquals("12345", student.getStudentId());
    }

    @Test
    public void testGetName() {
        assertEquals("Alice", student.getName());
    }

    @Test
    public void testGetGrades() {
        assertTrue(student.getGrades().isEmpty());
    }

    @Test
    public void testAddGradeValid() {
        student.addGrade(80);
        assertEquals(Arrays.asList(80.0), student.getGrades());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGradeInvalid() {
        student.addGrade(-10);
    }

    @Test
    public void testGetAverageGradeEmpty() {
        assertEquals(0, student.getAverageGrade(), 0.001);
    }

    @Test
    public void testGetAverageGrade() {
        student.addGrade(90);
        student.addGrade(80);
        assertEquals(85, student.getAverageGrade(), 0.001);
    }

    @Test
    public void testToString() {
        assertEquals("Student{studentId='12345', name='Alice', grades=[]}", student.toString());
    }

}