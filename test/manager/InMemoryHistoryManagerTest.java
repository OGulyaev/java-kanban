package manager;

import model.Status;
import model.Task;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {
    public HistoryManager historyManager = Managers.getDefaultHistory();
    public TaskManager taskManager = Managers.getDefault();
    public int historyMaxSize = historyManager.getHistoryMaxSize();

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
/*
Влад, привет! Спасибо за ревью!
 Сделал еще один тест, поэтому добавил доп метод getHistoryMaxSize в HistoryManager,
 чтобы использовать ту же константу:
 */
    @Test
    void controlMaxHistorySizeIs10() {
        for (int i = 0; i <= historyMaxSize + 1; i++) {
            Task task = new Task(taskManager.generateId(),"Test addNewTask", "Test addNewTask description", Status.NEW);
            historyManager.addInHistory(task);
        }
        List<Task> history = historyManager.getHistory();
        assertEquals(historyMaxSize, history.size(), "Размер истории не 10.");
    }

}