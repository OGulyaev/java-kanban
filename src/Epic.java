import java.util.ArrayList;

public class Epic extends Task {
    public ArrayList<Subtask> subtasks = new ArrayList<>();

    public Epic(String name, String description) {
        super(name, description);
    }

    public void addSubtask(Subtask subtask) {
        subtasks.add(subtask);
    }

    @Override
    public String toString() {
        return "Epic ID " + id + ", " + name + ", " + description + ", " + status;
    }

}