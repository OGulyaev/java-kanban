import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Epic> epics;
    HashMap<Integer, Subtask> subtasks;
    public static Integer id = 0;

    public void createTask(Task task) {
        id++;
        tasks.put(id, task);
    }

    public HashMap<Integer, Task> getTaskList() {
        for (Map.Entry<Integer, Task> task : tasks.entrySet()) {
            Task t = task.getValue();
            System.out.println(task.getKey() + ", " + t.name + ", " + t.description + ", " + t.status);
        }
        return tasks;
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
