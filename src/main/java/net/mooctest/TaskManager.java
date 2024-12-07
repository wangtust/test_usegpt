package net.mooctest;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<String> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        if (task == null || task.isEmpty()) {
            throw new IllegalArgumentException("Task cannot be null or empty.");
        }
        tasks.add(task);
    }

    public void removeTask(String task) {
        if (task == null || task.isEmpty()) {
            throw new IllegalArgumentException("Task cannot be null or empty.");
        }
        if (!tasks.contains(task)) {
            throw new IllegalArgumentException("Task not found.");
        }
        tasks.remove(task);
    }

    public List<String> getTasks() {
        return tasks;
    }

    public int getTaskCount() {
        return tasks.size();
    }

    @Override
    public String toString() {
        return "TaskManager{" +
                "tasks=" + tasks +
                '}';
    }
}