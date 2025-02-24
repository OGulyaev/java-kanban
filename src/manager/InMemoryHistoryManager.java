package manager;

import model.Epic;
import model.Subtask;
import model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    //Managers manager = new Managers();
    //TaskManager taskManager = manager.getDefault();
    public static InMemoryTaskManager taskManager = new InMemoryTaskManager();
    public List<Task> taskHistory = new ArrayList<>();
    public ArrayList<Task> tasks = taskManager.getTaskList();
    public ArrayList<Epic> epics = taskManager.getEpicList();
    public ArrayList<Subtask> subtasks = taskManager.getSubtaskList();

    @Override
    public List<Task> getHistory() {
        return taskHistory;
    }

    @Override
    public void addInHistory(Task task) {
        if (taskHistory.size() >= 10) taskHistory.removeFirst();
        taskHistory.add(task);
/*        if (task instanceof Epic) {
            taskHistory.add(epics.get(task.getId()));
        } else if (task instanceof Subtask) {
            taskHistory.add(subtasks.get(task.getId()));
        } else {
            taskHistory.add(tasks.get(task.getId()));
        }
        */
    }
}
