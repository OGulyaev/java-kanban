package manager;

import model.Epic;
import model.Status;
import model.Subtask;
import model.Task;

import java.util.ArrayList;
import java.util.List;

public interface TaskManager {
    List<? extends Task> getHistory();

    int generateId();

    void createTask(Task task);

    void createEpic(Epic epic);

    void createSubtask(Subtask subtask);

    ArrayList<Task> getTaskList();

    ArrayList<Epic> getEpicList();

    ArrayList<Subtask> getSubtaskList();

    Task getTask(int id);

    Epic getEpic(int id);

    Subtask getSubtask(int id);

    void deleteAllTasks();

    void deleteAllEpics();

    void deleteAllSubtasks();

    void updateTask(Task task);

    void updateEpic(Epic newEpic);

    void updateSubtask(Subtask subtask);

    void deleteTask(int taskId);

    void deleteEpic(int epicId);

    void deleteSubtask(Integer subtaskId);

    ArrayList<Subtask> getSubtasksOfEpic(int epicId);
}
