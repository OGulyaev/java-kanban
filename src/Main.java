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
        taskManager.createSubtask(new Subtask("Sub of Ep 3", "Sub deccription", Status.NEW, 3));

        System.out.println("Вывод списка всех задач:");
        taskManager.getTaskList();
        taskManager.getEpicList();
        taskManager.getSubtaskList();

        System.out.println("Обновление задачи и вывод обновленной задачи по ID:");
        taskManager.updateTask(2, new Task("Cange task name", "Change deccript", Status.IN_PROGRESS));
        taskManager.getTask(2);
        taskManager.updateEpic(4, new Epic("Updane epic name", "Upd epic description", Status.IN_PROGRESS));
        taskManager.getEpic(4);
        taskManager.updateSubtask(6, new Subtask("Upd sub name", "Upd sub description", Status.IN_PROGRESS, 4));
        taskManager.getSubtask(6);

        System.out.println("Получение списка подзадач по ID эпика:");
        taskManager.getSubtasksOfEpic(3);
        taskManager.getSubtasksOfEpic(4);

        System.out.println("Удаление задачи, эпика и подзадачи по ID. Вывод оставшихся:");
        taskManager.deleteTask(1);
        taskManager.deleteEpic(3);
        taskManager.deleteSubtask(7);
        taskManager.getTaskList();
        taskManager.getEpicList();
        taskManager.getSubtaskList();

        System.out.println("Удаление всех задач и вывод пустых списков:");
        taskManager.deleteAllTasks();
        taskManager.deleteAllEpics();
        taskManager.deleteAllSubtasks();
        taskManager.getTaskList();
        taskManager.getEpicList();
        taskManager.getSubtaskList();

    }
}
