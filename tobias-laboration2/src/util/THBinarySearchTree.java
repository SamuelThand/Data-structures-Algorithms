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

    /**
     * Pre-order traversal of the current tree.
     * root -> left child -> right child, iterative
     */
    public void preOrderTraversal() {
        if (root == null) {
            return;
        }
        THStack<Node<T>> stack = new THStack<>();
        Node<T> current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                System.out.print(current.item);
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                current = current.right;
            }
        }
        System.out.println();
    }

    /**
     * Post-order traversal of the current tree.
     * left child -> right child -> root, iterative
     */
    public void postOrderTraversal() {
        if (root == null) {
            return;
        }
        THStack<Node<T>> stack = new THStack<>();
        Node<T> current = root;
        Node<T> lastVisited = null;
        Node<T> peek = null;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                peek = stack.peek();
                if (peek.right != null && lastVisited != peek.right) {
                    current = peek.right;
                } else {
                    System.out.print(peek.item);
                    lastVisited = stack.pop();
                }
            }
        }
        System.out.println();
    }

    /**
     * In-order traversal of the current tree.
     * left child -> root -> right child, iterative
     */
    public void inOrderTraversal() {
        if (root == null) {
            return;
        }
        THStack<Node<T>> stack = new THStack<>();
        Node<T> current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.print(current.item);
                current = current.right;
            }
        }
        System.out.println();
    }

    /**
     * Level-order traversal of the current tree.
     * One level at a time, iterative
     */
    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }
        THLinkedList<Node<T>> queue = new THLinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            Node<T> current = queue.removeFirst();
            System.out.print(current.item);
            if (current.left != null) {
                queue.addLast(current.left);
            }
            if (current.right != null) {
                queue.addLast(current.right);
            }
        }
        System.out.println();
    }

    /**
     * Pre-order traversal of the current tree.
     * root -> left child -> right child, recursive
     */
    public void preOrderTraversalRec() {
        preOrderTraversalRec(root);
        System.out.println();
    }

    private void preOrderTraversalRec(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.item);
        preOrderTraversalRec(node.left);
        preOrderTraversalRec(node.right);
    }

    /**
     * Post-order traversal of the current tree.
     * left child -> right child -> root, recursive
     */
    public void postOrderTraversalRec() {
        postOrderTraversalRec(root);
        System.out.println();
    }

    private void postOrderTraversalRec(Node<T> node) {
        if (node == null) {
            return;
        }
        postOrderTraversalRec(node.left);
        postOrderTraversalRec(node.right);
        System.out.print(node.item);
    }

    /**
     * In-order traversal of the current tree.
     * left child -> root -> right child, recursive
     */
    public void inOrderTraversalRec() {
        inOrderTraversalRec(root);
        System.out.println();
    }

    private void inOrderTraversalRec(Node<T> node) {
        if (node == null) {
            return;
        }
        inOrderTraversalRec(node.left);
        System.out.print(node.item);
        inOrderTraversalRec(node.right);
    }

    /**
     * level-order traversal of the current tree.
     * One level at a time, recursive
     */
    public void levelOrderTraversalRec() {
        int height = height(root);
        for (int i = 1; i <= height; i++) {
            levelOrderTraversalRec(root, i);
        }
        System.out.println();
    }

    private void levelOrderTraversalRec(Node<T> node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.item);
        } else {
            levelOrderTraversalRec(node.left, level - 1);
            levelOrderTraversalRec(node.right, level - 1);
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
