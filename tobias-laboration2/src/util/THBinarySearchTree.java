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

    public boolean find(T item) {
        return find(item, root);
    }

    private boolean find(T item, Node<T> node) {
        if (node == null) {
            return false;
        }
        int compared = item.compareTo(node.item);
        if (compared < 0) {
            return find(item, node.left);
        } else if (compared > 0) {
            return find(item, node.right);
        }
        return true;
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

    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public void print() {
        System.out.println("-".repeat(40));
        print(root, 0);
        System.out.println("-".repeat(40));
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
