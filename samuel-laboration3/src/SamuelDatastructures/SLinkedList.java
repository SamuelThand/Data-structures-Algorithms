package SamuelDatastructures;

public class SLinkedList<T> {

    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    SLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtTail(T item) {
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

    public boolean remove(T item) {
        if (isEmpty())
            return false;

        var currentNode = this.head;

        // The item is in the head
        if (currentNode.getItem().equals(item)) {
            this.head = head.getNextNode();
            if (head == null) // If head becomes null, the list is empty and tail should also be null
                tail = null;
            else
                head.setPreviousNode(null);
            size--;
            return true;
        }

        while (currentNode != null) {
            if (currentNode.getItem().equals(item)) { // Match
                var previous = currentNode.getPreviousNode();
                var next = currentNode.getNextNode();

                //Remove by relinking
                if (previous != null)
                    previous.setNextNode(next);
                if (next != null)
                    next.setPreviousNode(previous);
                if (currentNode == tail) // The item is in the tail
                    tail = previous;
                size--;
                return true;
            }

            currentNode = currentNode.getNextNode();
        }

        return false;
    }

    public boolean contains(T item) {
        var currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getItem().equals(item))
                return true;

            currentNode = currentNode.getNextNode();
        }
        return false;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

}
