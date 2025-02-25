package manager;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    public static Managers manager = new Managers();
    public static TaskManager taskManager = manager.getDefault();
    public static List<Task> taskHistory = new ArrayList<>();

    @Override
    public List<Task> getHistory() {
        return taskHistory;
    }

    @Override
    public void addInHistory(Task task) {
        if (taskHistory.size() >= 10) taskHistory.removeFirst();
        taskHistory.add(task);
    }
}
