package manager;
// ManagersUtils
public final class Managers {
    public static TaskManager getDefault(){
        TaskManager inMemoryTaskManager = new InMemoryTaskManager();
        return inMemoryTaskManager;
    }
}
