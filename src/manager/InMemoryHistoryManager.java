package manager;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private static final int MAX_HISTORY_SIZE = 10;
    public List<Task> taskHistory = new ArrayList<>();

    @Override
    public ArrayList<Task> getHistory() {
        return new ArrayList<Task>(taskHistory);
    }

    @Override
    public void addInHistory(Task task) {
        if (task != null) {
            if (taskHistory.size() >= MAX_HISTORY_SIZE) taskHistory.remove(0);
            taskHistory.add(task);
        }
    }

}
