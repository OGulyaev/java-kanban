package model;

public class Subtask extends Task {
    private int epicId;

    public Subtask(int id, String name, String description, Status status, int newEpicId) {
        super(id, name, description, status);
        epicId = newEpicId;
    }

    public int getEpicId() {
        return epicId;
    }

    @Override
    public String toString() {
        return "Subtask ID " + getId() + ", EpicID " + getEpicId() + ", " + getName() + ", " + getDescription()
                + ", " + getStatus();
    }

}