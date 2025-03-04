package manager;

import model.Task;

import java.util.ArrayList;

public interface HistoryManager {
    ArrayList<Task> getHistory();

    void addInHistory(Task task);

    int getHistoryMaxSize();
}
