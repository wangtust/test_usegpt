package net.mooctest;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TaskManagerTest {

    private TaskManager taskManager;

    @Before
    public void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testAddTask() {
        taskManager.addTask("Task1");
        assertEquals(1, taskManager.getTaskCount());
        assertEquals("Task1", taskManager.getTasks().get(0));
    }

    @Test
    public void testRemoveTask() {
        taskManager.addTask("Task1");
        taskManager.removeTask("Task1");
        assertEquals(0, taskManager.getTaskCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullTask() {
        taskManager.addTask(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEmptyTask() {
        taskManager.addTask("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNullTask() {
        taskManager.removeTask(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingTask() {
        taskManager.removeTask("NonExistingTask");
    }

    @Test
    public void testGetTaskCount() {
        assertEquals(0, taskManager.getTaskCount());
        taskManager.addTask("Task1");
        assertEquals(1, taskManager.getTaskCount());
    }

    @Test
    public void testToString() {
        assertEquals("TaskManager{tasks=[]}", taskManager.toString());
        taskManager.addTask("Task1");
        assertEquals("TaskManager{tasks=[Task1]}", taskManager.toString());
    }

}