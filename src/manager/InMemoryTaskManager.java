package manager;

import model.*;
import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryTaskManager implements TaskManager {
    public static Managers manager = new Managers();
    public static HistoryManager historyManager = manager.getDefaultHistory();
    public HashMap<Integer, Task> tasks = new HashMap<>();
    public HashMap<Integer, Epic> epics = new HashMap<>();
    public HashMap<Integer, Subtask> subtasks = new HashMap<>();
    public Integer id = 0;

    @Override
    public int generateId() {
        id++;
        return id;
    }

    @Override
    public void createTask(Task task) {
        tasks.put(id, task);
    }

    @Override
    public void createEpic(Epic epic) {
        epics.put(id, epic);
        epic.setStatus(Status.NEW);
    }

    @Override
    public void createSubtask(Subtask subtask) {
        if (epics.get(subtask.getEpicId()) != null) {
            subtasks.put(id, subtask);
            Epic epic = epics.get(subtask.getEpicId());
            epic.addSubtask(subtask);
            checkOfEpicStatus(subtask.getEpicId());
        }
    }

    @Override
    public ArrayList<Task> getTaskList() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public ArrayList<Epic> getEpicList() {
        return new ArrayList<>(epics.values());
    }

    @Override
    public ArrayList<Subtask> getSubtaskList() {
        return new ArrayList<>(subtasks.values());
    }

    @Override
    public Task getTask(int id) {
        historyManager.addInHistory(tasks.get(id));
        return tasks.get(id);
    }

    @Override
    public Epic getEpic(int id) {
        historyManager.addInHistory(epics.get(id));
        return epics.get(id);
    }

    @Override
    public Subtask getSubtask(int id) {
        historyManager.addInHistory(subtasks.get(id));
        return subtasks.get(id);
    }

    @Override
    public void deleteAllTasks() {
        tasks.clear();
    }

    @Override
    public void deleteAllEpics() {
        epics.clear();
        subtasks.clear();
    }

    @Override
    public void deleteAllSubtasks() {
        subtasks.clear();
        if (epics != null) {
            for (Epic e : epics.values()) {
                e.setSubtasks(new ArrayList<>());
                e.setStatus(Status.NEW);
            }
        }
    }

    @Override
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void updateEpic(Epic newEpic) {
        Epic oldEpic = epics.get(newEpic.getId());
        if (oldEpic != null) {
            oldEpic.setName(newEpic.getName());
            oldEpic.setDescription(newEpic.getDescription());
        }
      }

    @Override
    public void updateSubtask(Subtask subtask) {
        subtasks.get(subtask.getId()).setName(subtask.getName());
        subtasks.get(subtask.getId()).setDescription(subtask.getDescription());
        subtasks.get(subtask.getId()).setStatus(subtask.getStatus());
        checkOfEpicStatus(subtasks.get(subtask.getId()).getEpicId());
    }

    @Override
    public void deleteTask(int taskId) {
            tasks.remove(taskId);
    }

    @Override
    public void deleteEpic(int epicId) {
        if (epics.get(epicId) != null) {
            for (Integer sub : epics.get(epicId).getSubtasks()) {
                subtasks.remove(sub);
            }
            epics.remove(epicId);
        }
    }

    @Override
    public void deleteSubtask(Integer subtaskId) {
        if (subtasks.get(subtaskId) != null) {
            int epicOfSubID = subtasks.get(subtaskId).getEpicId();
            subtasks.remove(subtaskId);
            if (epics.get(epicOfSubID) != null) {
                ArrayList<Integer> subsOfEpic = epics.get(epicOfSubID).getSubtasks();
                subsOfEpic.remove(subtaskId);
                epics.get(epicOfSubID).setSubtasks(subsOfEpic);
                checkOfEpicStatus(epicOfSubID);
            }
        }
    }

    public void checkOfEpicStatus(int epicId) {
        ArrayList<Subtask> subtasksOfEpic = getSubtasksOfEpic(epicId);
        if (!subtasksOfEpic.isEmpty()) {
            Status epicStatus = subtasksOfEpic.getFirst().getStatus();
            for (Subtask sub : subtasksOfEpic) {
                if (!sub.getStatus().equals(epicStatus)) {
                    epicStatus = Status.IN_PROGRESS;
                    break;
                }
            }
            epics.get(epicId).setStatus(epicStatus);
        } else {
            epics.get(epicId).setStatus(Status.NEW);
        }
    }

    @Override
    public ArrayList<Subtask> getSubtasksOfEpic(int epicId) {
        if (epics.get(epicId) != null) {
            ArrayList<Subtask> subOfEpic = new ArrayList<>();
            ArrayList<Integer> subOfEpicIds = epics.get(epicId).getSubtasks();
            for (int subId : subOfEpicIds) {
                subOfEpic.add(subtasks.get(subId));
            }
            return subOfEpic;
        } else {
           return new ArrayList<>();
        }
    }

}
