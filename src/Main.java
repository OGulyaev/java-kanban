import manager.TaskManager;
import model.Epic;
import model.Status;
import model.Subtask;
import model.Task;

import java.util.ArrayList;

public class Main {
    public static TaskManager taskManager = new TaskManager();
    public static void main(String[] args) {
        //manager.TaskManager taskManager = new manager.TaskManager();
        taskManager.createTask(new Task(taskManager.generateId(), "First task name", "First deccript", Status.NEW));
        taskManager.createTask(new Task(taskManager.generateId(), "Second task name", "Second deccript", Status.NEW));
        taskManager.createEpic(new Epic(taskManager.generateId(), "Epic name one", "Epic deccript one",
                Status.NEW));
        taskManager.createEpic(new Epic(taskManager.generateId(), "Epic name two", "Epic deccription two",
                Status.NEW));
        taskManager.createSubtask(new Subtask(taskManager.generateId(), "Sub name one Ep 3", "Sub deccript one",
                Status.NEW, 3));
        taskManager.createSubtask(new Subtask(taskManager.generateId(), "Sub name two Ep 4", "Sub deccript two",
                Status.NEW, 4));
        taskManager.createSubtask(new Subtask(taskManager.generateId(), "Sub name three Ep 4", "Sub descript three",
                Status.NEW, 4));
        taskManager.createSubtask(new Subtask(taskManager.generateId(), "Sub of Ep 3", "Sub description",
                Status.NEW, 3));
        taskManager.createSubtask(new Subtask(taskManager.generateId(), "Sub of Ep 10", "Sub description",
                Status.NEW, 10));

        System.out.println("Вывод списка всех задач:");
        printAllTasks(taskManager.getTaskList());
        printAllEpics(taskManager.getEpicList());
        printAllSubtasks(taskManager.getSubtaskList());

        System.out.println("Обновление задачи и вывод обновленной задачи по ID:");
        taskManager.updateTask(new Task(2, "Change task name", "Change descript", Status.NEW));
        printAllTasks(taskManager.getTaskList());
        taskManager.updateEpic(new Epic(4, "Update epic name", "Upd epic description",
                Status.NEW));
        printEpic(4);
        taskManager.updateSubtask(new Subtask(6, "Upd sub name", "Upd sub description",
                Status.NEW, 4));
        printSubtask(6);

        System.out.println("Получение списка подзадач по ID эпика:");
        printSubtasksOfEpic(3);
        printSubtasksOfEpic(4);

        System.out.println("Проверка перехода эпика в статус DONE при завершении всех подзадач:");
        taskManager.updateSubtask(new Subtask(6, "Sub 6", "Upd sub description",
                Status.DONE, 4));
        printEpic(4);
        taskManager.updateSubtask(new Subtask(7, "Sub 7", "Upd sub description",
                Status.DONE, 4));
        printEpic(4);

        System.out.println("Проверка перехода эпика в статус IN_PROGRESS при изменении статуса подзадачи:");
        taskManager.updateSubtask(new Subtask(6, "Sub 6", "Upd sub description",
                Status.NEW, 4));
        printEpic(4);
        System.out.println("Проверка перехода эпика в статус NEW, когда все подзадачи NEW:");
        taskManager.updateSubtask(new Subtask(7, "Sub 7", "Upd sub description",
                Status.NEW, 4));
        printEpic(4);

        System.out.println("Удаление задачи, эпика и подзадачи по ID. Вывод оставшихся:");
        taskManager.deleteTask(1);
        taskManager.deleteEpic(3);
        taskManager.deleteSubtask(5);
        taskManager.deleteSubtask(7);
        printAllTasks(taskManager.getTaskList());
        printAllEpics(taskManager.getEpicList());
        printAllSubtasks(taskManager.getSubtaskList());

        System.out.println("Удаление всех задач и вывод пустых списков:");
        taskManager.deleteAllTasks();
        taskManager.deleteAllEpics();
        taskManager.deleteAllSubtasks();
        printAllTasks(taskManager.getTaskList());
        printAllEpics(taskManager.getEpicList());
        printSubtasksOfEpic(3);
        printSubtasksOfEpic(4);
        printAllSubtasks(taskManager.getSubtaskList());

    }

    public static void printAllTasks(ArrayList<Task> allTasks) {
        for (Task t : allTasks) {
            System.out.println(t);
        }
    }

    public static void printAllEpics(ArrayList<Epic> allEpics) {
        for (Epic e : allEpics) {
            System.out.println(e);
        }
    }

    public static void printAllSubtasks(ArrayList<Subtask> allSubtasks) {
        for (Subtask s : allSubtasks) {
            System.out.println(s);
        }
    }

    public static void printTask(int id) {
        System.out.println(taskManager.getTask(id));
    }

    public static void printEpic(int id) {
        System.out.println(taskManager.getEpic(id));
    }

    public static void printSubtask(int id) {
        System.out.println(taskManager.getSubtask(id));
    }

    public static void printSubtasksOfEpic(int epicId) {
        for (Subtask subtask : taskManager.getSubtasksOfEpic(epicId)) {
            System.out.println(subtask);
        }
    }

}
