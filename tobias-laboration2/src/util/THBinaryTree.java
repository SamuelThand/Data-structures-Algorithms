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
        subRoot.item.compareTo(item);
        return true;
    }

    public void compareToRoot(T item) {
        System.out.println(this.root.item.compareTo(item));
    }

    private static class Node<T> {
        public T item;
        public Node<T> left;
        public Node<T> right;

        public Node(T item) {
            this.item = item;
            this.left = null;
            this.right = null;
        }
    }
}
