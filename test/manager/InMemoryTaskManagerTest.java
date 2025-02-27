package manager;

import model.Epic;
import model.Status;
import model.Subtask;
import model.Task;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class InMemoryTaskManagerTest {
    public TaskManager taskManager = Managers.getDefault();

    @Test
    void addNewTaskAndControlTaskList() {
        Task task = new Task(taskManager.generateId(),"Test addNewTask", "Test addNewTask description", Status.NEW);
        taskManager.createTask(task);
        assertNotNull(taskManager.getTask(task.getId()), "Задача не найдена.");
        assertEquals(task, taskManager.getTask(task.getId()), "Задачи не совпадают.");

        final List<Task> tasks = taskManager.getTaskList();
        assertNotNull(tasks, "Задачи не возвращаются.");
        assertEquals(1, tasks.size(), "Неверное количество задач.");
        assertEquals(task, tasks.get(0), "Задачи не совпадают.");
    }

    @Test
    void addNewEpic() {
        Epic epic = new Epic(taskManager.generateId(),"Test addNewTask", "Test addNewTask description", Status.NEW);
        taskManager.createEpic(epic);
        assertNotNull(taskManager.getEpic(epic.getId()), "Задача не найдена.");
        assertEquals(epic, taskManager.getEpic(epic.getId()), "Задачи не совпадают.");
    }

    @Test
    void addNewSubtask() {
        Epic epic = new Epic(taskManager.generateId(),"Test addNewTask", "Test addNewTask description", Status.NEW);
        taskManager.createEpic(epic);
        Subtask subtask = new Subtask(taskManager.generateId(),"Test addNewTask", "Test addNewTask description", Status.NEW, epic.getId());
        taskManager.createSubtask(subtask);
        assertNotNull(taskManager.getSubtask(subtask.getId()), "Задача не найдена.");
        assertEquals(subtask, taskManager.getSubtask(subtask.getId()), "Задачи не совпадают.");
    }



}