package manager;

import model.Task;
import java.util.List;

public interface HistoryManager {
    List<Task> getHistory();

    void addInHistory(Task task);
}
