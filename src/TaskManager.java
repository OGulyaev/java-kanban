import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();
    HashMap<Integer, Subtask> subtasks = new HashMap<>();
    public static Integer id = 0;

    public void createTask(Task task) {
        id++;
        tasks.put(id, task);
        task.id = id;
    }

    public void createEpic(Epic epic) {
        id++;
        epics.put(id, epic);
        epic.id = id;
    }

    public void createSubtask(Subtask subtask) {
        id++;
        subtasks.put(id, subtask);
        subtask.id = id;
        Epic epic = epics.get(subtask.epicId);
        epic.addSubtask(subtask.id);
    }

    public HashMap<Integer, Task> getTaskList() {
        for (Map.Entry<Integer, Task> task : tasks.entrySet()) {
            Task t = task.getValue();
            System.out.println(t);
        }
        return tasks;
    }

    public HashMap<Integer, Epic> getEpicList() {
        for (Map.Entry<Integer, Epic> epic : epics.entrySet()) {
            Epic e = epic.getValue();
            System.out.println(e.toString());
        }
        return epics;
    }

    public HashMap<Integer, Subtask> getSubtaskList() {
        for (Map.Entry<Integer, Subtask> subtask : subtasks.entrySet()) {
            Subtask s = subtask.getValue();
            System.out.println(s.toString());
        }
        return subtasks;
    }

    public Task getTask(int id) {
        System.out.println(tasks.get(id));
        return tasks.get(id);
    }

    public Epic getEpic(int id) {
        System.out.println(epics.get(id));
        return epics.get(id);
    }

    public Subtask getSubtask(int id) {
        System.out.println(subtasks.get(id));
        return subtasks.get(id);
    }

    public HashMap<Integer, Task> deleteAllTasks() {
        tasks.clear();
        return tasks;
    }

    public HashMap<Integer, Epic> deleteAllEpics() {
        epics.clear();
        return epics;
    }

    public HashMap<Integer, Subtask> deleteAllSubtasks() {
        subtasks.clear();
        return subtasks;
    }

    public void updateTask(int taskId, Task task) {
        tasks.replace(taskId, task);
        task.id = taskId;
    }

    public void updateEpic(int epicId, Epic newEpic) {
        ArrayList<Integer> subTasks = epics.get(epicId).subtasks;
        epics.replace(epicId, newEpic);
        newEpic.id = epicId;
        newEpic.subtasks = subTasks;
    }

    public void updateSubtask(int subId, Subtask subtask) {
        int epicOfSubId = subtasks.get(subId).epicId;
        subtasks.replace(subId, subtask);
        subtask.id = subId;
        subtask.epicId = epicOfSubId;
        HashMap<Integer, Subtask> subtasksOfEpic = getSubtasksOfEpic(epicOfSubId);
        boolean isDone = false;
        //boolean isNew = false;
        for (Map.Entry<Integer, Subtask> sub : subtasksOfEpic.entrySet()) {
            if (!sub.getValue().status.equals(Status.DONE)) {
                isDone = false;
                return;
            } else {
                isDone = true;
            }
        }
        if (isDone) {
            epics.get(epicOfSubId).status = Status.DONE;
        }
        // add update status to IN_PROGRESS. if isNew then NEW. else of !isDone && !isNew then IN_PROGRESS
    }

    public HashMap<Integer, Task> deleteTask(int taskId) {
        tasks.remove(taskId);
        return tasks;
    }

    public HashMap<Integer, Epic> deleteEpic(int epicId) {
        epics.remove(epicId);
        return epics;
    }

    public HashMap<Integer, Subtask> deleteSubtask(int subtaskId) {
        subtasks.remove(subtaskId);
        return subtasks;
    }

    public HashMap<Integer, Subtask> getSubtasksOfEpic(int epicId) {
        HashMap<Integer, Subtask> subtasksOfEpic = new HashMap<>();
        ArrayList<Integer> subs = epics.get(epicId).subtasks;
        for (Integer sub : subs) {
            subtasksOfEpic.put(sub, subtasks.get(sub));
        }
        return subtasksOfEpic;
    }

    public void printSubtasksOfEpic(int epicId) {
        HashMap<Integer, Subtask> subtasksOfEpic = getSubtasksOfEpic(epicId);
        for (Map.Entry<Integer, Subtask> sub : subtasksOfEpic.entrySet()) {
            System.out.println(sub.getValue().toString());
        }
    }


/*
 +   getTaskList() {

    }
+    delAllTasks() {

    }
 +   getTask(int id) {

    }
 +   createTask(Task task) {

    }
 +   updateTask(Task task) {

    }
+    delTask(int id) {

    }

+    getTasksOfEpic() {

    }
    manageEpicStatus() {

    }
*/
}
