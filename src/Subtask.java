public class Subtask extends Task {
    public int id;
    public int epicId;

    public Subtask(String name, String description, Status status, int newEpicId) {
        super(name, description, status);
        epicId = newEpicId;
    }
    @Override
    public String toString() {
        return "Subtask ID " + id + ", EpicID " + epicId + ", " + name + ", " + description + ", " + status;
    }

}