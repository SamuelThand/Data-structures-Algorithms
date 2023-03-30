import java.util.Iterator;

public class SamuelLinkedList<T> implements Iterable<T> {

    private class SamuelLinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.getItem();
            current = current.getNextNode();
            return item;
        }
    }

    private Node<T> head;

    public SamuelLinkedList() {
        this.head = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new SamuelLinkedListIterator();
    }

    public void add(T item) {
        var node = new Node<>(item);

        if (isEmpty()) {
            this.head = node;
        } else {
            var currentNode = this.head;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }

            currentNode.setNextNode(node);
        }
    }

    public T remove(T item) {
        if (isEmpty()) {
            return null;
        } else if (head.getItem().equals(item)) {
            var removedItem = this.head.getItem();
            this.head = head.getNextNode();
            return removedItem;
        } else {
            var nextNode = head.getNextNode();
            var currentNode = head;
            while (nextNode != null) {
                if (nextNode.getItem().equals(item)) {
                    var removedItem = nextNode.getItem();
                    currentNode.setNextNode(nextNode.getNextNode());
                    return removedItem;
                }
                currentNode = nextNode;
                nextNode = nextNode.getNextNode();
            }

            return null;
        }
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
        int count = 0;
        Node<T> currentNode = head;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.getNextNode();
        }
        return count;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

}
