import java.util.HashMap;
import java.util.Map;

public class Main {
    public static TaskManager taskManager = new TaskManager();
    public static void main(String[] args) {
        //TaskManager taskManager = new TaskManager();
        taskManager.createTask(new Task("First task name", "First deccript"));
        taskManager.createTask(new Task("Second task name", "Second deccript"));
        taskManager.createEpic(new Epic("Epic name one", "Epic deccript one"));
        taskManager.createEpic(new Epic("Epic name two", "Epic deccription two"));
        taskManager.createSubtask(new Subtask("Sub name one Ep 3", "Sub deccript one", 3));
        taskManager.createSubtask(new Subtask("Sub name two Ep 4", "Sub deccript two", 4));
        taskManager.createSubtask(new Subtask("Sub name three Ep 4", "Sub descript three", 4));
        taskManager.createSubtask(new Subtask("Sub of Ep 3", "Sub description", 3));

        System.out.println("Вывод списка всех задач:");
        printAllTasks(taskManager.getTaskList());
        printAllEpics(taskManager.getEpicList());
        printAllSubtasks(taskManager.getSubtaskList());

        System.out.println("Обновление задачи и вывод обновленной задачи по ID:");
        taskManager.updateTask(2, new Task("Cange task name", "Change deccript"), Status.IN_PROGRESS);
        printTask(2);
        taskManager.updateEpic(4, new Epic("Update epic name", "Upd epic description"));
        printEpic(4);
        taskManager.updateSubtask(6, new Subtask("Upd sub name", "Upd sub description", 4), Status.IN_PROGRESS);
        printSubtask(6);

        System.out.println("Получение списка подзадач по ID эпика:");
        printSubtasksOfEpic(3);
        printSubtasksOfEpic(4);

        System.out.println("Проверка перехода эпика в статус DONE при завершении всех подзадач:");
        taskManager.updateSubtask(6, new Subtask("Sub 6", "Upd sub description", 4), Status.DONE);
        printEpic(4);
        taskManager.updateSubtask(7, new Subtask("Sub 7", "Upd sub description", 4), Status.DONE);
        printEpic(4);

        System.out.println("Проверка перехода эпика в статус IN_PROGRESS при изменении статуса подзадачи:");
        taskManager.updateSubtask(6, new Subtask("Sub 6", "Upd sub description", 4), Status.NEW);
        printEpic(4);
        System.out.println("Проверка перехода эпика в статус NEW, когда все подзадачи NEW:");
        taskManager.updateSubtask(7, new Subtask("Sub 7", "Upd sub description", 4), Status.NEW);
        printEpic(4);

        System.out.println("Удаление задачи, эпика и подзадачи по ID. Вывод оставшихся:");
        taskManager.deleteTask(1);
        taskManager.deleteEpic(3);
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
        printAllSubtasks(taskManager.getSubtaskList());

    }

    public static void printAllTasks(HashMap<Integer, Task> allTasks) {
        for (Map.Entry<Integer, Task> task : allTasks.entrySet()) {
            Task t = task.getValue();
            System.out.println(t);
        }
    }

    public static void printAllEpics(HashMap<Integer, Epic> allEpics) {
        for (Map.Entry<Integer, Epic> epic : allEpics.entrySet()) {
            Epic e = epic.getValue();
            System.out.println(e);
        }
    }

    public static void printAllSubtasks(HashMap<Integer, Subtask> allSubtasks) {
        for (Map.Entry<Integer, Subtask> subtask : allSubtasks.entrySet()) {
            Subtask s = subtask.getValue();
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
