package model;

import manager.Managers;
import manager.TaskManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpicTest {
    public TaskManager taskManager = Managers.getDefault();

    @Test
    void controlEqualsOfEpicsIfIdEpicsIsEquals() {
        Epic epic = new Epic(taskManager.generateId(),"Test addNewTask", "Test addNewTask description", Status.NEW);
        taskManager.createEpic(epic);
        assertEquals(epic, taskManager.getEpic(epic.getId()), "Задачи не совпадают.");
        assertTrue(epic.equals(taskManager.getEpic(epic.getId())));
    }

}