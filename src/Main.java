import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        taskManager.createTask(new Task("First task name", "First deccript", Status.NEW));
        taskManager.createTask(new Task("Second task name", "Second deccript", Status.NEW));
        taskManager.createEpic(new Epic("Epic name one", "Epic deccript one", Status.NEW));
        taskManager.createEpic(new Epic("Epic name two", "Epic deccription two", Status.NEW));
        taskManager.createSubtask(new Subtask("Sub name one Ep 3", "Sub deccript one", Status.NEW, 3));
        taskManager.createSubtask(new Subtask("Sub name two Ep 4", "Sub deccript two", Status.NEW, 4));
        taskManager.createSubtask(new Subtask("Sub name three Ep 4", "Sub deccript three", Status.NEW, 4));

        taskManager.getTaskList();
        taskManager.getEpicList();
        taskManager.getSubtaskList();

        taskManager.getTask(2);
        taskManager.getEpic(4);
        taskManager.getSubtask(5);
    }
}
