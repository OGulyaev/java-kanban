package manager;

import model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    public static List<Task> taskHistory = new ArrayList<>();
    public HashMap<Integer, Node<Task>> history = new HashMap<>();
    public Node<Task> head;
    public Node<Task> tail;
    private static int size = 0;

    @Override
    public ArrayList<Task> getHistory() {
        Node<Task> element = head;
        while (element != null) {
            taskHistory.add(element.data);
            element = element.next;
        }
        return new ArrayList<>(taskHistory);
    }

    @Override
    public void add(Task task) {
        if (task != null) {
            if (history.containsKey(task.getId())) {
                remove(task.getId());
            }
            final Node<Task> oldTail = tail;
            final Node<Task> newNode = new Node<>(oldTail, task, null);
            tail = newNode;
            if (oldTail == null) {
                head = newNode;
            } else {
                oldTail.next = newNode;
            }
            size++;
            history.put(task.getId(), newNode);
        }
    }

    @Override
    public void remove(int id) {

        Node<Task> removeNode = history.get(id);

        Node<Task> oldNext = removeNode.next;
        Node<Task> oldPrev = removeNode.prev;
        if (oldPrev != null) oldPrev.next = oldNext;
        if (oldNext != null) oldNext.prev = oldPrev;
        size--;
        history.remove(id);

    }

}
