package SamuelDatastructures;

public class AVLTreeNode<T extends Comparable<T>> {

    AVLTreeNode<T> left;
    AVLTreeNode<T> right;
    T data;
    int height;

    public AVLTreeNode(T data) {
        this.data = data;
    }

    public void insert(T data) {
        if (this.data == null)
            this.data = data;

        else
            this.recursiveInsert(this, data);

//        else if (data.compareTo(this.data) <= 0) {
//            if (this.left == null)
//                this.left = new AVLTreeNode<>(data);
//            else
//                this.left.insert(data);
//
//        } else {
//            if (this.right == null)
//                this.right = new AVLTreeNode<>(data);
//            else
//                this.right.insert(data);
//        }
    }

    private AVLTreeNode<T> recursiveInsert(AVLTreeNode<T> node, T data) {
        if (node == null)
            return new AVLTreeNode<>(data);

        if (data.compareTo(this.data) <= 0)
            node.left = recursiveInsert(node.left, data);
        else
            node.right = recursiveInsert(node.right, data);

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        var balance = calculateBalance(node);

        if (balance > 1) // Left-heavy tree
            if (data.compareTo(node.left.data) < 0) // node would be in right subtree of the right child of the unbalanced node
                return rotateRight(node);
            else if (data.compareTo(node.left.data) > 0) // node would be in right subtree of left child of unbalanced node
                return rotateLeftRight(node);

        if (balance < -1) // Right-heavy tree
            if (data.compareTo(node.right.data) > 0) // node would be in left subtree of the left child of the unbalanced node
                return rotateLeft(node);
            else if (data.compareTo(node.right.data) < 0) // node would be in left subtree of right child of unbalanced node
                return rotateRightLeft(node);


        return node; // Balanced tree
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

        return node;
    }

    private AVLTreeNode<T> rotateLeft(AVLTreeNode<T> node) {
        var root = node.right;
        node.right = root.left;
        root.left = node;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

//        node.height = calculateHeight(node);
//        root.height = calculateHeight(root);

        return root;
    }

    private AVLTreeNode<T> rotateRight(AVLTreeNode<T> node) {
        var root = node.left;
        node.left = root.right;
        root.right = node;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

//        node.height = calculateHeight(node);
//        root.height = calculateHeight(root);

        return root;
    }

    private AVLTreeNode<T> rotateLeftRight(AVLTreeNode<T> node) {
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    private AVLTreeNode<T> rotateRightLeft(AVLTreeNode<T> node) {
        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }


    private T findSubtreeMinimumValue(AVLTreeNode<T> node) {
        return node.right == null ? node.data : findSubtreeMinimumValue(node.right);
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

    public void clear() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    public int calculateHeight(AVLTreeNode<T> node) {
//        if (node.data == null)
        if (node == null)
            return -1;

        int leftHeight = (node.left != null) ? calculateHeight(node.left) : -1;
        int rightHeight = (node.right != null) ? calculateHeight(node.right) : -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    private int leftHeight() {
        return this.left != null ? 1 + this.left.leftHeight() : -1;
    }

    private int rightHeight() {
        return this.right != null ? 1 + this.right.rightHeight() : -1;
    }


    public boolean isBalanced() {
        return Math.abs(leftHeight() - rightHeight()) <= 1;
    }

    private int calculateBalance(AVLTreeNode<T> node) {
        return getHeight(node.left) - getHeight(node.right);
    }

    public void print() {
        recursivePrint("", true);
    }

    public void count() {
        //TODO implement
    }

    public int getHeight(AVLTreeNode<T> node) {
        return node == null ? -1 : node.height; //TODO is -1 return on null needed?
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

}
