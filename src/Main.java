import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        TaskManager tas = new TaskManager();
        tas.createTask(new Task("First name", "First deccript", Status.NEW));
        tas.createTask(new Task("Second name", "Second deccript", Status.NEW));
        tas.getTaskList();

    }
}
