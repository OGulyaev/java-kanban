package manager;

import model.Task;

import java.util.ArrayList;

public interface HistoryManager {
    ArrayList<Task> getHistory();
// заменить название метода addInHostory на add
    void addInHistory(Task task);
}
