package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class TaskManagerTest {

    @Test
    public void testAddTask() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Task 1");
        List<String> tasks = taskManager.getTasks();
        assertEquals(1, tasks.size());
        assertEquals("Task 1", tasks.get(0));
    }

    @Test
    public void testRemoveTask() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Task 1");

        // Test removing an existing task
        taskManager.removeTask("Task 1");
        assertEquals(0, taskManager.getTasks().size());

        // Test removing a non-existing task
        try {
            taskManager.removeTask("Task 2");
            fail("Expected IllegalArgumentException not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Task not found.", e.getMessage());
        }
    }

    @Test
    public void testTaskCount() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Task 1");
        taskManager.addTask("Task 2");
        assertEquals(2, taskManager.getTaskCount());
    }
}