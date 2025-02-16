package model;

public class Subtask extends Task {
    private int epicId;

    public Subtask(String name, String description, Status status, int newEpicId) {
        super(name, description, status);
        epicId = newEpicId;
    }

    public int getEpicId() {
        return epicId;
    }

    @Override
    public String toString() {
        return "model.Subtask ID " + getId() + ", EpicID " + getEpicId() + ", " + getName() + ", " + getDescription()
                + ", " + getStatus();
    }

}