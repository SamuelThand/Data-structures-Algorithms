package SamuelDatastructures;

public class SamuelLinkedListQueue<T> {

    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    SamuelLinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public T insert() {
        //TODO do
    }

    public T deque() {
        //TODO do
    }

    public T removeHead() {
        if (isEmpty()) {
            return null;
        } else {
            var item = head.getItem();
            head = head.getNextNode();
            return item;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

}
