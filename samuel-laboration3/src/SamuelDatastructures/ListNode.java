package SamuelDatastructures;

public class ListNode<T> {

    private final T item;
    private ListNode<T> nextNode;
    private ListNode<T> previousNode;

    public ListNode(T item) {
        this.item = item;
    }

    public T getItem() {
        return this.item;
    }

    public ListNode<T> getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(ListNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public ListNode<T> getPreviousNode() {
        return this.previousNode;
    }

    public void setPreviousNode(ListNode<T> previousNode) {
        this.previousNode = previousNode;
    }

}
