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
            System.out.println("Task " + task.getKey() + ", ID " + t.id + ", " + t.name + ", " + t.description + ", " + t.status);
        }
        return tasks;
    }

    public HashMap<Integer, Epic> getEpicList() {
        for (Map.Entry<Integer, Epic> epic : epics.entrySet()) {
            Epic e = epic.getValue();
            System.out.println("Epic " + epic.getKey() + ", ID " + e.id + ", " + e.name + ", " + e.description + ", " + e.status);
        }
        return epics;
    }

    public HashMap<Integer, Subtask> getSubtaskList() {
        for (Map.Entry<Integer, Subtask> subtask : subtasks.entrySet()) {
            Subtask s = subtask.getValue();
            System.out.println("Subtask " + subtask.getKey() + ", ID " + s.id + ", EpicID " + s.epicId + ", " + s.name + ", " + s.description + ", " + s.status);
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

/*
    getTaskList() {

    }
    delAllTasks() {

    }
    getTask(int id) {

    }
    createTask(Task task) {

    }
    updateTask(Task task) {

    }
    delTask(int id) {

    }

    getTasksOfEpic() {

    }
    manageEpicStatus() {

    }
*/
}
