package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A linked list implementation.
 * @param <T> type of item to hold in the list
 */
public class THA3LinkedList<T> implements Iterable<T> {

    private final Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Constructor for THLinkedList.
     */
    public THA3LinkedList() {
        this.tail = new Node<>(null, null);
        this.head = new Node<>(null, tail);
        this.size = 0;
    }

    /**
     * Get amount of items stored in the list.
     * @return items in list
     */
    public int size() {
        return size;
    }

    /**
     * Check if list is empty.
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add an item to the list at a specific index.
     * @param index index to add item at
     * @param item item to add
     */
    public void add(int index, T item) {
        if (index == size) {
            addLast(item);
        } else {
            Node<T> node = getNode(index);
            node.next = new Node<>(item, node.next);
            size++;
        }
    }

    /**
     * Add an item to the beginning of the list.
     * @param item item to add
     */
    public void addFirst(T item) {
        add(0, item);
    }

    /**
     * Add an item to the end of the list.
     * @param item item to add
     */
    public void addLast(T item) {
        Node<T> node = new Node<>(null, null);
        tail.item = item;
        tail.next = node;
        tail = node;
        size++;
    }

    /**
     * Set an item at a specific index.
     * @param index index to set item at
     * @param item item to set
     * @return old item
     */
    public T set(int index, T item) {
        Node<T> node = getNode(index);
        T oldItem = node.item;
        node.item = item;
        return oldItem;
    }

    /**
     * Remove an item at a specific index.
     * @param index index to remove item at
     * @return removed item
     */
    public T remove(int index) {
        Node<T> prevNode;
        if (index == 0) {
            prevNode = head;
        } else {
            prevNode = getNode(index - 1);

        }
        T item = prevNode.next.item;
        prevNode.next = prevNode.next.next;
        size--;
        return item;
    }

    public T remove(T item) {
        Node<T> prevNode = head;
        Node<T> node = head.next;
        while (node != null && node.item != null) {
            if (node.item.equals(item)) {
                prevNode.next = node.next;
                size--;
                return item;
            }
            prevNode = node;
            node = node.next;
        }
        return null;
    }

    /**
     * Remove the first item in the list.
     * @return removed item
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * Remove the last item in the list.
     * @return removed item
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * Get an item at a specific index.
     * @param index index of item
     * @return item at index
     */
    public T get(int index) {
        return getNode(index).item;
    }

    /**
     * Get the first item in the list.
     * @return first item
     */
    public T getFirst() {
        return head.next.item;
    }

    /**
     * Get the last item in the list.
     * @return last item
     */
    public T getLast() {
        return getNode(size - 1).item;
    }

    public boolean contains(T item) {
        for (T t : this) {
            if (t.equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove all items from the list.
     */
    public void clear() {
        this.tail = new Node<>(null, null);
        this.head.next = tail;
        this.size = 0;
    }

    /**
     * Get the Node at a specific index.
     */
    private Node<T> getNode(int index) {
        if (outOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * Check if index is out of bounds.
     */
    private boolean outOfBounds(int index) {
        return index < 0 || index >= size;
    }

    @Override
    public Iterator<T> iterator() {
        return new THLinkedListIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        THLinkedListIterator it = new THLinkedListIterator();
        int index = 0;
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }

    /**
     * Iterator for THLinkedList.
     */
    private class THLinkedListIterator implements Iterator<T> {
        private Node<T> current = head.next;

        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = current.item;
            current = current.next;
            return item;
        }

    }

    /**
     * Node for THLinkedList.
     * Contains an item and a reference to the next node.
     */
    private static class Node<T> {
        public T item;
        public Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

    }

}
