package SamuelDatastructures;

public class BinaryTreeNode<T extends Comparable<T>> {

    // Have been put as public to enable easy forced modification of the tree for testing
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    T data;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public void insert(T data) {
        if (this.data == null) //Empty node
            this.data = data;

        else if (data.compareTo(this.data) <= 0) { //The incoming data is <= the nodes data
            if (this.left == null)
                this.left = new BinaryTreeNode<>(data);
            else
                this.left.insert(data); // Recursive call down the left subtree

        } else {
            if (this.right == null)
                this.right = new BinaryTreeNode<>(data);
            else
                this.right.insert(data); // Recursive call down the right subtree
        }
    }

    public boolean isMaxHeap() {
        return isCompleteTree() && hasMaxHeapProperty();
    }

    public boolean isCompleteTree() {
        var queue = new SLinkedList<BinaryTreeNode<T>>();
        boolean missingNode = false;
        queue.insertAtTail(this);

        while (!queue.isEmpty()) { // Breadth first traversal
            var node = queue.deque();

            if (node.left != null) {
                if (missingNode) // Node with a missing child was encountered before the last node - incomplete
                    return false;
                else
                    queue.insertAtTail(node.left);
            } else
                missingNode = true;

            if (node.right != null) {
                if (missingNode) // Node with a missing child was encountered before the last node - incomplete
                    return false;
                else
                    queue.insertAtTail(node.right);
            } else
                missingNode = true;

        }

        return true;
    }

    public boolean hasMaxHeapProperty() {
        if (this.left != null)
            if (this.data.compareTo(this.left.data) < 0 || !this.left.hasMaxHeapProperty())
                return false;
        if (this.right != null)
            if (this.data.compareTo(this.right.data) < 0 || !this.right.hasMaxHeapProperty())
                return false;

        return true;
    }

    public BinaryTreeNode<T> remove(T data) {
        return this.recursiveRemove(this, data);
    }

    private BinaryTreeNode<T> recursiveRemove(BinaryTreeNode<T> node, T data) {
        if (node == null)
            return null;
        else if (data.compareTo(node.data) < 0)
            node.left = recursiveRemove(node.left, data); // Recursive call down the left subtree
        else if (data.compareTo(node.data) > 0)
            node.right = recursiveRemove(node.right, data); // Recursive call down the right subtree
        else {

            // Case 1: Node has no children
            if (node.left == null && node.right == null)
                return null;

                // Case 2: Node has 1 child
            else if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

                //Case 3: Node as 2 children
            else {
                node.data = findSubtreeMinimumValue(node.left);
                node.left = recursiveRemove(node.left, node.data);
            }
        }

        return node;
    }

    private T findSubtreeMinimumValue(BinaryTreeNode<T> node) {
        return node.right == null ? node.data : findSubtreeMinimumValue(node.right);
    }

    public void print() {
        recursivePrint("", true);
    }

    private void recursivePrint(String indentation, boolean isLeft) {
        if (this.right != null)
            this.right.recursivePrint(indentation + (isLeft ? "│   " : "    "), false);

        System.out.println(indentation + (isLeft ? "└── " : "┌── ") + data);

        if (this.left != null)
            this.left.recursivePrint(indentation + (isLeft ? "    " : "│   "), true);

    }

}
