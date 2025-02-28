package model;

import manager.Managers;
import manager.TaskManager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    public TaskManager taskManager = Managers.getDefault();

    @Test
    void controlEqualsOfTasksIfIdTasksIsEquals() {
        Task task = new Task(taskManager.generateId(),"Test addNewTask", "Test addNewTask description", Status.NEW);
        taskManager.createTask(task);
        assertEquals(task, taskManager.getTask(task.getId()), "Задачи не совпадают.");
        assertTrue(task.equals(taskManager.getTask(task.getId())));
    }

}