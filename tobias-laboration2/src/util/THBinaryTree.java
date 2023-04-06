package util;

public class THBinaryTree<T extends Comparable<T>> {
    Node<T> root;

    public THBinaryTree() {
        this.root = null;
    }

    public boolean insert(T item) {
        if (this.root == null) {
            this.root = new Node<>(item);
            return true;
        }
        return insert(item, this.root);
    }

    private boolean insert(T item, Node<T> subRoot) {
        return true;
    }

    private static class Node<T> {
        T item;
        Node<T> left;
        Node<T> right;

        Node(T item) {
            this(item, null, null);
        }

        Node(T item, Node<T> left, Node<T> right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }

    }
}
