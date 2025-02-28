package model;

import manager.Managers;
import manager.TaskManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtaskTest {
    public TaskManager taskManager = Managers.getDefault();

    @Test
    void controlEqualsOfSubtasksIfIdSubtasksIsEquals() {
        Epic epic = new Epic(taskManager.generateId(),"Test addNewTask", "Test addNewTask description", Status.NEW);
        taskManager.createEpic(epic);
        Subtask subtask = new Subtask(taskManager.generateId(),"Test addNewTask", "Test addNewTask description", Status.NEW, epic.getId());
        taskManager.createSubtask(subtask);
        assertNotNull(taskManager.getSubtask(subtask.getId()), "Задача не найдена.");
        assertEquals(subtask, taskManager.getSubtask(subtask.getId()), "Задачи не совпадают.");
        assertTrue(subtask.equals(taskManager.getSubtask(subtask.getId())));
    }

}