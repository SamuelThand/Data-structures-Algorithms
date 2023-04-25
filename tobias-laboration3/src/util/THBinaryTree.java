package util;

public class THBinaryTree<T extends Comparable<T>> {
    public Node<T> root;

    public THBinaryTree(T item) {
        this.root = new Node<>(item);
    }

    public boolean checkBalance() {
        return checkBalance(root);
    }

    private boolean checkBalance(Node<T> node) {
        if (node == null) {
            return true;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return checkBalance(node.left) && checkBalance(node.right);
    }

    public int height(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public void print() {
        System.out.println();
        print(root, 0);
    }

    private void print(Node<T> node, int level) {
        if (node == null) {
            return;
        }
        print(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("-  ");
        }
        System.out.println(node.item);
        print(node.left, level + 1);
    }

    public static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        public T item;
        public Node<T> left;
        public Node<T> right;

        Node(T item) {
            this(item, null, null);
        }

        Node(T item, Node<T> left, Node<T> right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }

        public T getItem() {
            return item;
        }

        public Node<T> setLeft(T item) {
            return this.left = new Node<>(item);
        }

        public Node<T> setRight(T item) {
            return this.right = new Node<>(item);
        }

        public void setItem(T item) {
            this.item = item;
        }

        public void removeLeft() {
            this.left = null;
        }

        public void removeRight() {
            this.right = null;
        }

        @Override
        public int compareTo(final Node<T> o) {
            return item.compareTo(o.item);
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }
}
