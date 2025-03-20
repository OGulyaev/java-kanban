package manager;

import model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    public List<Task> taskHistory = new ArrayList<>();
    public HashMap<Integer, Node<Task>> history = new HashMap<>();
    public Node<Task> head;
    public Node<Task> tail;
    private static int size = 0;

    @Override
    public ArrayList<Task> getHistory() {
        // добавить перебор двусвязного списка с добавлением в taskHistory
        return new ArrayList<Task>(taskHistory);
    }

    @Override
    public void add(Task task) {
        if (task != null) {
            if (history.get(task.getId()) != null) remove(task.getId());
            final Node<Task> oldTail = tail;
            final Node<Task> newNode = new Node<>(oldTail, task, null);
            tail = newNode;
            if (oldTail == null)
                head = newNode;
            else
                oldTail.next = newNode;
            size++;
            history.put(task.getId(), newNode);
        }


    }

    @Override
    public void remove(int id) {

        history.remove(id);

    }

}
