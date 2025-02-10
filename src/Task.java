public class Task {
    public String name;
    public String description;
    public Status status;
    public int id;

    public Task(String name, String description, Status status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID " + id + ", " + name + ", " + description + ", " + status;
    }
}
