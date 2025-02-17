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

    public int generateId() {
        id++;
        return id;
    }

    public void createTask(Task task) {
        tasks.put(id, task);
    }

    public void createEpic(Epic epic) {
        epics.put(id, epic);
        epic.setStatus(Status.NEW);
    }

    public void createSubtask(Subtask subtask) {
        if (epics.get(subtask.getEpicId()) != null) {
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
            for (Epic e : epics.values()) {
                e.setSubtasks(new ArrayList<>());
                e.setStatus(Status.NEW);
            }
        }
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void updateEpic(Epic newEpic) {
        Epic oldEpic = epics.get(newEpic.getId());
        if (oldEpic != null) {
            oldEpic.setName(newEpic.getName());
            oldEpic.setDescription(newEpic.getDescription());
        }
      }

    public void updateSubtask(Subtask subtask) {
        subtasks.get(subtask.getId()).setName(subtask.getName());
        subtasks.get(subtask.getId()).setDescription(subtask.getDescription());
        subtasks.get(subtask.getId()).setStatus(subtask.getStatus());
        checkOfEpicStatus(subtasks.get(subtask.getId()).getEpicId());
    }

    private void checkOfEpicStatus(int epicId) {
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

    public void deleteTask(int taskId) {
            tasks.remove(taskId);
    }

    public void deleteEpic(int epicId) {
        if (epics.get(epicId) != null) {
            for (Integer sub : epics.get(epicId).getSubtasks()) {
                subtasks.remove(sub);
            }
            epics.remove(epicId);
        }
    }

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
