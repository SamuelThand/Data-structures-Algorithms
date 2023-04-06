package util;

public class THBinarySearchTree<T extends Comparable<T>> {
    Node<T> root;

    public THBinarySearchTree() {
        this.root = null;
    }

    public void insert(T item) {
        root = insert(item, root);
    }

    private Node<T> insert(T item, Node<T> node) {
        if (node == null) {
            return new Node<>(item);
        }
        int compared = item.compareTo(node.item);
        if (compared < 0) {
            node.left = insert(item, node.left);
        } else if (compared > 0) {
            node.right = insert(item, node.right);
        }
        return node;
    }

    public void remove(T item) {
        root = remove(item, root);
    }

    private Node<T> remove(T item, Node<T> node) {
        if (node == null) {
            return null;
        }
        int compared = item.compareTo(node.item);
        if (compared < 0) {
            node.left = remove(item, node.left);
        } else if (compared > 0) {
            node.right = remove(item, node.right);
        } else if (node.left != null && node.right != null) {  // Match and two children
            node.item = findMin(node.right).item;
            node.right = remove(node.item, node.right);
        } else { // Match and one or zero children
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    private Node<T> findMin(Node<T> node) {
        if (node != null) {
            while (node.left != null) {
                node = node.left;
            }
        }
        return node;
    }

    private Node<T> findMax(Node<T> node) {
        if (node != null) {
            while (node.right != null) {
                node = node.right;
            }
        }
        return node;
    }

    public void print() {
        print(root);
    }

    private void print(Node<T> node) {
        if (node != null) {
            print(node.left);
            System.out.println(node.item);
            print(node.right);
        }
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
