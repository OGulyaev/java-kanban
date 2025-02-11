import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        if (id != 0) {
            hash = hash + Objects.hashCode(id);
        }
        hash = hash * 31;
        return hash;
    }
}
