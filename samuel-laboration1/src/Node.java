public class Node<T> {

    private final T item;
    private Node<T> nextNode;

    public Node(T item) {
        this.item = item;
    }

    public T getItem() {
        return this.item;
    }

    public Node<T> getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

}