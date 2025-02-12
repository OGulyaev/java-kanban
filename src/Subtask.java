public class Subtask extends Task {
    public int epicId;

    public Subtask(String name, String description, int newEpicId) {
        super(name, description);
        epicId = newEpicId;
    }

    @Override
    public String toString() {
        return "Subtask ID " + id + ", EpicID " + epicId + ", " + name + ", " + description + ", " + status;
    }

}