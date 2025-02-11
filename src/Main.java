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

        System.out.println("Вывод списка всех задач:");
        taskManager.getTaskList();
        taskManager.getEpicList();
        taskManager.getSubtaskList();

        System.out.println("Вывод по ID:");
        taskManager.getTask(2);
        taskManager.getEpic(4);
        taskManager.getSubtask(5);

        System.out.println("Обновление задачи и вывод обновленной задачи по ID:");
        taskManager.updateTask(2, new Task("Cange task name", "Change deccript", Status.IN_PROGRESS));
        taskManager.getTaskList();


        System.out.println("Удаление всех задач и вывод пустых списков:");
        taskManager.deleteAllTasks();
        taskManager.deleteAllEpics();
        taskManager.deleteAllSubtasks();
        taskManager.getTaskList();
        taskManager.getEpicList();
        taskManager.getSubtaskList();

    }
}
