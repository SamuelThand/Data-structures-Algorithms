package util;

public class THA3Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    private int size;

    public THA3Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public T dequeue() {
        if (head == null) {
            return null;
        }
        T item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public T peek() {
        if (head == null) {
            return null;
        }
        return head.item;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    private static class Node<T> {
        T item;
        Node<T> next;

        public Node(T item) {
            this.item = item;
            this.next = null;
        }
    }
}
