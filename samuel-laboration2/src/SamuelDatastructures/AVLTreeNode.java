package SamuelDatastructures;

public class AVLTreeNode<T extends Comparable<T>> {

    AVLTreeNode<T> left;
    AVLTreeNode<T> right;
    T data;
    int height;

    public AVLTreeNode(T data) {
        this.data = data;
        this.height = 0;
    }

    public AVLTreeNode<T> insert(T data) {
        if (this.data == null) {
            this.data = data;
            return this;
        }

        else
            return this.recursiveInsert(this, data);
    }

    private AVLTreeNode<T> recursiveInsert(AVLTreeNode<T> node, T data) {
        if (node == null)
            return new AVLTreeNode<>(data);

        if (data.compareTo(node.data) <= 0)
            node.left = recursiveInsert(node.left, data);
        else
            node.right = recursiveInsert(node.right, data);

        node.height = calculateHeight(node);
        return doBalancing(node, calculateBalance(node));
    }

    public AVLTreeNode<T> remove(T data) {
        return this.recursiveRemove(this, data);
    }

    private AVLTreeNode<T> recursiveRemove(AVLTreeNode<T> node, T data) {
        if (node == null)
            return null;
        else if (data.compareTo(node.data) < 0)
            node.left = recursiveRemove(node.left, data);
        else if (data.compareTo(node.data) > 0)
            node.right = recursiveRemove(node.right, data);
        else {
            if (node.left == null && node.right == null)
                return null;
            else if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                node.data = findSubtreeMinimumValue(node.left);
                node.left = recursiveRemove(node.left, node.data);
            }
        }

        node.height = calculateHeight(node);
        return doBalancing(node, calculateBalance(node));
    }

    private T findSubtreeMinimumValue(AVLTreeNode<T> node) {
        return node.right == null ? node.data : findSubtreeMinimumValue(node.right);
    }

    private AVLTreeNode<T> doBalancing(AVLTreeNode<T> node, int balance) {
        // Left-heavy tree
        if (balance > 1)
            if (calculateBalance(node.left) >= 0) // node would be in right subtree of the right child of the unbalanced node
                return rotateRight(node);
            else
                return rotateLeftRight(node); // node would be in right subtree of left child of unbalanced node

        // Right-heavy tree
        else if (balance < -1)
            if (calculateBalance(node.right) <= 0)  // node would be in left subtree of the left child of the unbalanced node
                return rotateLeft(node);
            else
                return rotateRightLeft(node); // node would be in left subtree of right child of unbalanced node

        // Balanced tree
        return node;
    }


    private AVLTreeNode<T> rotateLeftRight(AVLTreeNode<T> node) {
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    private AVLTreeNode<T> rotateRightLeft(AVLTreeNode<T> node) {
        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }

    private AVLTreeNode<T> rotateLeft(AVLTreeNode<T> node) {
        var root = node.right;
        node.right = root.left;
        root.left = node;

        node.height = calculateHeight(node);
        root.height = calculateHeight(root);

        return root;
    }

    private AVLTreeNode<T> rotateRight(AVLTreeNode<T> node) {
        var root = node.left;
        node.left = root.right;
        root.right = node;

        node.height = calculateHeight(node);
        root.height = calculateHeight(root);

        return root;
    }

    private int calculateHeight(AVLTreeNode<T> node) {
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public AVLTreeNode<T> find(T data) {
        if (this.data == null)
            return null;
        else if (data.compareTo(this.data) == 0)
            return this;
        else if (data.compareTo(this.data) < 0)
            if (this.left == null)
                return null;
            else
                return this.left.find(data);
        else
        if (this.right == null)
            return null;
        else
            return this.right.find(data);
    }

    public boolean isBalanced() {
        return Math.abs(calculateBalance(this)) <= 1;
    }

    private int calculateBalance(AVLTreeNode<T> node) {
        return getHeight(node.left) - getHeight(node.right);
    }

    public int getHeight(AVLTreeNode<T> node) {
        return node == null ? -1 : node.height;
    }

    public int countLessThan(T data) {
        int count = 0;
        if (this.data != null) {
            if (this.data.compareTo(data) < 0)
                count++;
            if (this.left != null)
                count += this.left.countLessThan(data);
            if (this.right != null && this.data.compareTo(data) < 0)
                count += this.right.countLessThan(data);
        }

        return count;
    }


    public void print() {
        recursivePrint("", true);
    }

    private void recursivePrint(String indentation, boolean isLeft) {
        if (right != null) {
            right.recursivePrint(indentation + (isLeft ? "│   " : "    "), false);
        }

        System.out.println(indentation + (isLeft ? "└── " : "┌── ") + data);

        if (left != null) {
            left.recursivePrint(indentation + (isLeft ? "    " : "│   "), true);
        }

    }

    public void clear() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

}
