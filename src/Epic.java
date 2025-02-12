import java.util.ArrayList;

public class Epic extends Task {
    public ArrayList<Integer> subtasks = new ArrayList<>();

    public Epic(String name, String description) {
        super(name, description);
    }

    public void addSubtask(Integer subtaskId) {
        subtasks.add(subtaskId);
    }

    @Override
    public String toString() {
        return "Epic ID " + id + ", " + name + ", " + description + ", " + status;
    }

}