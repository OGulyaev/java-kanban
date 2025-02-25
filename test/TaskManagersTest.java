import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import manager.*;
import model.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManagersTest {
    public static Managers manager = new Managers();
    public static TaskManager taskManager = manager.getDefault();
    public static HistoryManager historyManager = manager.getDefaultHistory();
/*

    @Test
    void addNewTask() {
        Task task = new Task(taskManager.generateId(),"Test addNewTask", "Test addNewTask description", Status.NEW);

        //assertNotNull(taskManager.getTask(task.getId()), "Задача не найдена.");
        assertEquals(task, taskManager.getTask(task.getId()), "Задачи не совпадают.");

        final List<Task> tasks = taskManager.getTaskList();

        assertNotNull(tasks, "Задачи не возвращаются.");
        assertEquals(1, tasks.size(), "Неверное количество задач.");
        assertEquals(task, tasks.get(0), "Задачи не совпадают.");
    }
*/

    @Test
    void add() {
        Task task = new Task(taskManager.generateId(),"Test addNewTask", "Test addNewTask description", Status.NEW);
        historyManager.addInHistory(task);
        final List<Task> history = historyManager.getHistory();
        assertNotNull(history, "История не пустая.");
        //assertEquals(1, history.size(), "История не пустая.");
    }
}
