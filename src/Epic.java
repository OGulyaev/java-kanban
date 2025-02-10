import java.util.ArrayList;

public class Epic extends Task {
    public ArrayList<Integer> subtasks = new ArrayList<>();
    public int id;

    public Epic(String name, String description, Status status) {
        super(name, description, status);
    }

    public void addSubtask(Integer subtaskId) {
        subtasks.add(subtaskId);
    }

}
