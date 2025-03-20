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
/*

    @Test
    void controlMaxHistorySizeIs10() {
        int maxHistorySize = 10;
        for (int i = 0; i <= maxHistorySize + 1; i++) {
            Task task = new Task(taskManager.generateId(),"Test addNewTask", "Test addNewTask description", Status.NEW);
            historyManager.add(task);
        }
        List<Task> history = historyManager.getHistory();
        assertEquals(maxHistorySize, history.size(), "Размер истории не 10.");
    }
*/

}