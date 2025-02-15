import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    public HashMap<Integer, Task> tasks = new HashMap<>();
    public HashMap<Integer, Epic> epics = new HashMap<>();
    public HashMap<Integer, Subtask> subtasks = new HashMap<>();
    public static Integer id = 0;

    public void createTask(Task task) {
        id++;
        task.id = id;
        tasks.put(id, task);
    }

    public void createEpic(Epic epic) {
        id++;
        epic.id = id;
        epics.put(id, epic);
    }

    public void createSubtask(Subtask subtask) {
        id++;
        subtask.id = id;
        subtasks.put(id, subtask);
        Epic epic = epics.get(subtask.epicId);
        epic.addSubtask(subtask);
    }

    public HashMap<Integer, Task> getTaskList() {
        return tasks;
    }

    public HashMap<Integer, Epic> getEpicList() {
        return epics;
    }

    public HashMap<Integer, Subtask> getSubtaskList() {
        return subtasks;
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }

    public Epic getEpic(int id) {
        return epics.get(id);
    }

    public Subtask getSubtask(int id) {
        return subtasks.get(id);
    }

    public void deleteAllTasks() {
        tasks.clear();
    }

    public void deleteAllEpics() {
        epics.clear();
    }

    public void deleteAllSubtasks() {
        subtasks.clear();
    }

    public void updateTask(int taskId, Task task, Status status) {
        tasks.replace(taskId, task);
        task.id = taskId;
        task.status = status;
    }

    public void updateEpic(int epicId, Epic newEpic) {
        ArrayList<Integer> subTasks = epics.get(epicId).subtasks;
        epics.replace(epicId, newEpic);
        newEpic.id = epicId;
        newEpic.subtasks = subTasks;
    }

    public void updateSubtask(int subId, Subtask subtask, Status status) {
        int epicOfSubId = subtasks.get(subId).epicId;
        subtasks.replace(subId, subtask);
        subtask.id = subId;
        subtask.epicId = epicOfSubId;
        subtask.status = status;
        HashMap<Integer, Subtask> subtasksOfEpic = getSubtasksOfEpic(epicOfSubId);
        boolean isDone = false;
        boolean isNew = false;
        for (Map.Entry<Integer, Subtask> sub : subtasksOfEpic.entrySet()) {
            if (!sub.getValue().status.equals(Status.DONE)) {
                isDone = false;
                break;
            } else {
                isDone = true;
            }
        }
        if (isDone) {
            epics.get(epicOfSubId).status = Status.DONE;
        }
        for (Map.Entry<Integer, Subtask> sub : subtasksOfEpic.entrySet()) {
            if (!sub.getValue().status.equals(Status.NEW)) {
                isNew = false;
                break;
            } else {
                isNew = true;
            }
        }
        if (isNew) {
            epics.get(epicOfSubId).status = Status.NEW;
        }
        if (!isDone && !isNew) {
            epics.get(epicOfSubId).status = Status.IN_PROGRESS;
        }
    }

    public void deleteTask(int taskId) {
        tasks.remove(taskId);
    }

    public void deleteEpic(int epicId) {
        epics.remove(epicId);
    }

    public void deleteSubtask(int subtaskId) {
        subtasks.remove(subtaskId);
    }

    public ArrayList<Subtask> getSubtasksOfEpic(int epicId) {
        ArrayList<Subtask> subs = new ArrayList<>();
        subs = epics.get(epicId).subtasks;
        return subs;
    }

}
