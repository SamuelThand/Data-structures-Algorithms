package util;

public class THAVLTree<T extends Comparable<T>> {
    private Node<T> root;

    public THAVLTree() {
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
        return balanceTree(node);
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
        return balanceTree(node);
    }

    private Node<T> balanceTree(Node<T> node) {
        if (node == null) {
            return null;
        }
        int balance = getBalance(node);

        if (balance > 1) { // Left heavy
            node = leftHeavyBalancing(node);
        } else if (balance < -1) { // Right heavy
            node = rightHeavyBalancing(node);
        }
        updateHeight(node);
        return node;
    }

    /**
     * Determines what type of rotation to perform on a left heavy tree and performs the rotation.
     * @param node root node of rotation group
     * @return new root of rotation group
     */
    private Node<T> leftHeavyBalancing(Node<T> node) {
        int balance;
        balance = getBalance(node.left);
        if (balance >= 0) {
            node = rightRotation(node);
        } else {
            node = leftRightRotation(node);
        }
        return node;
    }

    /**
     * Determines what type of rotation to perform on a right heavy tree and performs the rotation.
     * @param node root node of rotation group
     * @return new root of rotation group
     */
    private Node<T> rightHeavyBalancing(Node<T> node) {
        int balance;
        balance = getBalance(node.right);
        if (balance <= 0) {
            node = leftRotation(node);
        } else {
            node = rightLeftRotation(node);
        }
        return node;
    }

    private int getBalance(Node<T> node) {
        return height(node.left) - height(node.right);
    }

    /**
     * Perform a right rotation.
     * @param node root node of rotation group
     * @return new root of rotation group
     */
    private Node<T> rightRotation(Node<T> node) {
        Node<T> parent = node.left;
        node.left = parent.right;
        parent.right = node;
        updateHeight(node);
        updateHeight(parent);
        return parent;
    }

    /**
     * Perform a left-right rotation.
     * @param node root node of rotation group
     * @return new root of rotation group
     */
    private Node<T> leftRightRotation(Node<T> node) {
        node.left = leftRotation(node.left);
        return rightRotation(node);
    }

    /**
     * Perform a left rotation.
     * @param node root node of rotation group
     * @return new root of rotation group
     */
    private Node<T> leftRotation(Node<T> node) {
        Node<T> parent = node.right;
        node.right = parent.left;
        parent.left = node;
        updateHeight(node);
        updateHeight(parent);
        return parent;
    }

    /**
     * Perform a right-left rotation.
     * @param node root node of rotation group
     * @return new root of rotation group
     */
    private Node<T> rightLeftRotation(Node<T> node) {
        node.right = rightRotation(node.right);
        return leftRotation(node);
    }

    /**
     * Update the height of the node.
     * @param node node to update height
     */
    private void updateHeight(final Node<T> node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private Node<T> findMin(Node<T> node) {
        if (node != null) {
            while (node.left != null) {
                node = node.left;
            }
        }
        return node;
    }

    /**
     * see if there is a node with the given value in the tree.
     * @param value value to compare
     * @return true if the value is in a node within the tree, false otherwise
     */
    public boolean find(T value) {
        return find(value, root);
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

    /**
     * See if the tree is balanced.
     * @return true if the tree is balanced, else false
     */
    public boolean checkBalance() {
        return checkBalance(root);
    }

    /**
     * See if the tree is balanced.
     * @param node root to subtree
     * @return true if the tree is balanced, else false
     */
    private boolean checkBalance(Node<T> node) {
        if (node == null) {
            return true;
        }
        if (Math.abs(getBalance(node)) > 1) {
            return false;
        }
        return checkBalance(node.left) && checkBalance(node.right);
    }

    /**
     * Get the height of the node.
     * @param node node to get height from
     * @return height of node, or -1 if null
     */
    private int height(Node<T> node) {
        return node != null ? node.height : -1;
    }

    /**
     * Print the tree to console.
     */
    public void print() {
        System.out.println();
        print(root, 0);
    }

    /**
     * Print the tree to console.
     * @param node node with value to print
     * @param level level of indentation
     */
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
     * Remove all nodes from the tree.
     */
    public void clear() {
        root = null;
    }

    /**
     * Count how many nodes have less value than a given value.
     *
     * @param value value to compare
     * @return amount of nodes with less value
     */
    public int count(T value) {
        int count = 0;
        if (root == null) {
            return count;
        }
        THStack<Node<T>> stack = new THStack<>();
        Node<T> current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                if (current.item.compareTo(value) >= 0) {
                    break;
                }
                count++;
                current = current.right;
            }
        }
        return count;
    }

    private static class Node<T> {
        T item;
        int height;
        Node<T> left;
        Node<T> right;

        Node(T item) {
            this(item, null, null);
        }

        Node(T item, Node<T> left, Node<T> right) {
            this.item = item;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }
}
