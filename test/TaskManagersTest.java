import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import manager.*;
import model.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManagersTest {
    public Managers manager = new Managers();
    public TaskManager taskManager = manager.getDefault();
    public HistoryManager historyManager = manager.getDefaultHistory();

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

    @Test
    void addTaskInHistoryAndControlEqualsOfTaskDataAfterAdd() {
        Task task = new Task(taskManager.generateId(),"Test addNewTask", "Test addNewTask description", Status.NEW);
        historyManager.addInHistory(task);
        final List<Task> history = historyManager.getHistory();
        assertNotNull(history, "История не пустая.");
        Task taskFromHistory = history.get(history.size()-1);
        assertEquals(task.getId(), taskFromHistory.getId(), "Задачи не совпадают.");
        assertEquals(task.getName(), taskFromHistory.getName(), "Задачи не совпадают.");
        assertEquals(task.getDescription(), taskFromHistory.getDescription(), "Задачи не совпадают.");
        assertEquals(task.getStatus(), taskFromHistory.getStatus(), "Задачи не совпадают.");
    }

}
