package net.mooctest;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TaskManagerTest {

    private TaskManager taskManager;

    @Before
    public void setup() {
        taskManager = new TaskManager();
    }

    @Test
    public void testAddTask() {
        taskManager.addTask("Task1");
        List<String> tasks = taskManager.getTasks();
        assertEquals(1, taskManager.getTaskCount());
        assertThat(tasks, hasItem("Task1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTaskWithNull() {
        taskManager.addTask(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTaskWithEmptyString() {
        taskManager.addTask("");
    }

    @Test
    public void testRemoveTask() {
        taskManager.addTask("Task1");
        taskManager.removeTask("Task1");
        List<String> tasks = taskManager.getTasks();
        assertEquals(0, taskManager.getTaskCount());
        assertThat(tasks, not(hasItem("Task1")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingTask() {
        taskManager.removeTask("Task2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTaskWithNull() {
        taskManager.removeTask(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTaskWithEmptyString() {
        taskManager.removeTask("");
    }

}