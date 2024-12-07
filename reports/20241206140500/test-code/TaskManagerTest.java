package net.mooctest;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TaskManagerTest {

    private TaskManager taskManager;

    @Before
    public void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testAddTask() {
        taskManager.addTask("Task 1");
        assertEquals(1, taskManager.getTaskCount());
        List<String> tasks = taskManager.getTasks();
        assertTrue(tasks.contains("Task 1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTaskWithNullTask() {
        taskManager.addTask(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTaskWithEmptyTask() {
        taskManager.addTask("");
    }

    @Test
    public void testRemoveTask() {
        taskManager.addTask("Task 1");
        taskManager.removeTask("Task 1");
        assertEquals(0, taskManager.getTaskCount());
        assertFalse(taskManager.getTasks().contains("Task 1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTaskWithNullTask() {
        taskManager.removeTask(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTaskWithEmptyTask() {
        taskManager.removeTask("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistentTask() {
        taskManager.addTask("Task 1");
        taskManager.removeTask("Task 2");
    }
}