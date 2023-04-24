package SamuelDatastructures;

public class SamuelLinkedListStackQueue<T> {

    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    SamuelLinkedListStackQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void enqueue(T item) {
        var node = new ListNode<>(item);

        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
            node.setNextNode(node);
            node.setPreviousNode(node);
        } else {
            this.tail.setNextNode(node);
            node.setPreviousNode(this.tail);
            this.tail = node;
        }

        this.size++;
    }

    public T deque() throws IllegalStateException {
        if (this.isEmpty())
            throw new IllegalStateException("Queue is empty");

        T data = this.head.getItem();
        this.head = this.head.getNextNode();
        if (this.head == null) // If list gets emptied, set tail to null as well
            this.tail = null;
        else
            this.head.setPreviousNode(null);

        this.size--;
        return data;
    }

    public T pop() throws IllegalStateException {
        if (this.isEmpty())
            throw new IllegalStateException("Queue is empty");

        T data = this.tail.getItem();
        this.tail = this.tail.getPreviousNode();
        if (this.tail == null) // If list gets emptied, set tail to null as well
            this.head = null;
        else
            this.tail.setNextNode(null);

        this.size--;
        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

}
