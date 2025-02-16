package manager;

import model.Epic;
import model.Status;
import model.Subtask;
import model.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    public HashMap<Integer, Task> tasks = new HashMap<>();
    public HashMap<Integer, Epic> epics = new HashMap<>();
    public HashMap<Integer, Subtask> subtasks = new HashMap<>();
    public Integer id = 0;

    public void createTask(Task task) {
        id++;
        task.setId(id);
        tasks.put(id, task);
    }

    public void createEpic(Epic epic) {
        id++;
        epic.setId(id);
        epics.put(id, epic);
        epic.setStatus(Status.NEW);
    }

    public void createSubtask(Subtask subtask) {
        if (epics.get(subtask.getEpicId()) != null) {
            id++;
            subtask.setId(id);
            subtasks.put(id, subtask);
            Epic epic = epics.get(subtask.getEpicId());
            epic.addSubtask(subtask);
            checkOfEpicStatus(subtask.getEpicId());
        }
    }

    public ArrayList<Task> getTaskList() {
        return new ArrayList<>(tasks.values());
    }

    public ArrayList<Epic> getEpicList() {
        return new ArrayList<>(epics.values());
    }

    public ArrayList<Subtask> getSubtaskList() {
        return new ArrayList<>(subtasks.values());
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
        subtasks.clear();
    }

    public void deleteAllSubtasks() {
        subtasks.clear();
        if (epics != null) {
            ArrayList<Epic> epicList = new ArrayList<>(epics.values());
            for (Epic e : epicList) {
                e.setSubtasks(new ArrayList<>());
            }
        }
    }

    public void updateTask(Task task) {
        id++;
        task.setId(id);
        tasks.put(id, task);
    }

    public void updateEpic(int epicId, Epic newEpic) {
        epics.get(epicId).setName(newEpic.getName());
        epics.get(epicId).setDescription(newEpic.getDescription());
      }

    public void updateSubtask(int subId, Subtask subtask) {
        subtasks.get(subId).setName(subtask.getName());
        subtasks.get(subId).setDescription(subtask.getDescription());
        subtasks.get(subId).setStatus(subtask.getStatus());
        checkOfEpicStatus(subtasks.get(subId).getEpicId());
    }

    private void checkOfEpicStatus(int epicId) {
        ArrayList<Subtask> subtasksOfEpic = getSubtasksOfEpic(epicId);
        if (subtasksOfEpic != null) {
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

    public void deleteTask(int taskId) {
        if (tasks.get(taskId) != null) {
            tasks.remove(taskId);
        }
    }

    public void deleteEpic(int epicId) {
        if (epics.get(epicId) != null) {
            for (Subtask sub : epics.get(epicId).getSubtasks()) {
                subtasks.remove(sub.getId());
            }
            epics.remove(epicId);
        }
    }

    public void deleteSubtask(int subtaskId) {
        if (subtasks.get(subtaskId) != null) {
            int epicOfSubID = subtasks.get(subtaskId).getEpicId();
            subtasks.remove(subtaskId);
            if (epics.get(epicOfSubID) != null) {
                checkOfEpicStatus(epicOfSubID);
            }
        }
    }

    public ArrayList<Subtask> getSubtasksOfEpic(int epicId) {
        if (epics.get(epicId) != null) {
            return epics.get(epicId).getSubtasks();
        } else {
           return new ArrayList<>();
        }
    }

}
