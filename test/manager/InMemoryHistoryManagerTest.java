package manager;

import model.Status;
import model.Task;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {
    public HistoryManager historyManager = Managers.getDefaultHistory();
    public TaskManager taskManager = Managers.getDefault();

    @Test
    void controlTaskDeleteFromHistoryIfTaskWasViewed() {
        Task task1 = new Task(11,"Test addNewTask", "Test addNewTask description", Status.NEW);
        historyManager.add(task1);
        historyManager.add(task1);
        assertEquals(1, historyManager.getHistory().size(), "Размер истории не 1");
    }

    @Test
    void addTaskInHistoryAndControlEqualsOfTaskDataAfterAdd() {
        Task task = new Task(taskManager.generateId(),"Test addNewTask", "Test addNewTask description", Status.NEW);
        historyManager.add(task);
        final List<Task> history = historyManager.getHistory();
        assertNotNull(history, "История не пустая.");
        Task taskFromHistory = history.get(history.size()-1);
        assertEquals(task.getId(), taskFromHistory.getId(), "Задачи не совпадают.");
        assertEquals(task.getName(), taskFromHistory.getName(), "Задачи не совпадают.");
        assertEquals(task.getDescription(), taskFromHistory.getDescription(), "Задачи не совпадают.");
        assertEquals(task.getStatus(), taskFromHistory.getStatus(), "Задачи не совпадают.");
    }

}