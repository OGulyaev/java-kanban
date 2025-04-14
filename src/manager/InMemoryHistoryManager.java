package manager;

import model.*;
import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryHistoryManager implements HistoryManager {
    public static HashMap<Integer, Node<Task>> history = new HashMap<>();
    public static Node<Task> head = null;
    public static Node<Task> tail = null;
    private static int size = 0;

    @Override
    public ArrayList<Task> getHistory() {
        ArrayList<Task> taskHistory = new ArrayList<>();
        Node<Task> current = head;
        while (current != null) {
            taskHistory.add(current.data);
            current = current.next;
        }
        return taskHistory;
    }

    @Override
    public void add(Task task) {
        if (task != null) {
            if (history.containsKey(task.getId())) {
                remove(task.getId());
            }
            history.put(task.getId(), linkLast(task));
        }
    }

    @Override
    public void remove(int id) {
        removeNode(history.get(id));
        history.remove(id);
    }

    public Node<Task> linkLast(Task task) {
        Node<Task> newNode = new Node<>(task);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return newNode;
    }

    private void removeNode(Node<Task> node) {
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }
        size--;
    }

}
