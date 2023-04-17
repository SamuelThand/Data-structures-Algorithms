package SamuelDatastructures;

public class BSTNode<T extends Comparable<T>> {

    BSTNode<T> left;
    BSTNode<T> right;
    T data;

    public BSTNode(T data) {
        this.data = data;
    }

    public void insert(T data) {
        if (this.data == null) //Empty node
            this.data = data;

        else if (data.compareTo(this.data) <= 0) { //The incoming data is <= the nodes data
            if (this.left == null)
                this.left = new BSTNode<>(data);
            else
                this.left.insert(data); // Recursive call down the left subtree

        } else {
            if (this.right == null)
                this.right = new BSTNode<>(data);
            else
                this.right.insert(data); // Recursive call down the right subtree
        }
    }

    public BSTNode<T> remove(T data) {
        return this.recursiveRemove(this, data);
    }

    private BSTNode<T> recursiveRemove(BSTNode<T> node, T data) {
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

    private T findSubtreeMinimumValue(BSTNode<T> node) {
        return node.right == null ? node.data : findSubtreeMinimumValue(node.right);
    }

    public void recursivePreOrderTraversal() {
        System.out.print(this.data + ", ");
        if (this.left != null)
            this.left.recursivePreOrderTraversal();
        if (this.right != null)
            this.right.recursivePreOrderTraversal();
    }

    public void recursivePostOrderTraversal() {
        if (this.left != null)
            this.left.recursivePostOrderTraversal();
        if (this.right != null)
            this.right.recursivePostOrderTraversal();
        System.out.print(this.data + ", ");
    }

    public void recursiveInOrderTraversal() {
        if (this.left != null)
            this.left.recursiveInOrderTraversal();
        System.out.print(this.data + ", ");
        if (this.right != null)
            this.right.recursiveInOrderTraversal();
    }

    public void recursiveLevelOrderTraversal() {
        for (int i = 0; i < getHeight() + 1; i++)
            printNodesForDepth(i); // Pass the height from low to high.
    }

    private void printNodesForDepth(int depth) { // Will traverse the tree from top to +1 level lower for each call, inefficient
        if (depth == 0)
            System.out.print(this.data + ", ");
        else {
            if (this.left != null)
                this.left.printNodesForDepth(depth - 1);
            if (this.right != null)
                this.right.printNodesForDepth(depth - 1);
        }
    }

    public void iterativePreOrderTraversal() {
        var stack = new SamuelLinkedListStackQueue<BSTNode<T>>();
        stack.enqueue(this);

        while (!stack.isEmpty()) {
            var node = stack.pop();
            System.out.print(node.data + ", ");
            if (node.right != null)
                stack.enqueue(node.right);
            if (node.left != null)
                stack.enqueue(node.left);
        }
    }

    public void iterativePostOrderTraversal() {
        var stack = new SamuelLinkedListStackQueue<BSTNode<T>>();
        var nodesInReverse = new SamuelLinkedListStackQueue<BSTNode<T>>();
        stack.enqueue(this);

        while (!stack.isEmpty()) { // Results in a list where the nodes can be popped in a Post-Order.
            var node = stack.pop();
            nodesInReverse.enqueue(node);
            if (node.left != null)
                stack.enqueue(node.left);
            if (node.right != null)
                stack.enqueue(node.right);
        }

        while (!nodesInReverse.isEmpty()) // Pop and print the reversed nodes
            System.out.print(nodesInReverse.pop().data + ", ");
    }

    public void iterativeInOrderTraversal() {
        var stack = new SamuelLinkedListStackQueue<BSTNode<T>>();
        var node = this;

        while (!stack.isEmpty() || node != null) {
            if (node != null) { // Push the left side of the left subtree unto the stack until encountering null
                stack.enqueue(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.data + ", ");
                node = node.right;
            }
        }
    }

    public void iterativeLevelOrderTraversal() {
        var queue = new SamuelLinkedListStackQueue<BSTNode<T>>();
        queue.enqueue(this);

        while (!queue.isEmpty()) {
            var node = queue.deque();
            System.out.print(node.data + ", ");
            if (node.left != null)
                queue.enqueue(node.left);
            if (node.right != null)
                queue.enqueue(node.right);
        }
    }

    public BSTNode<T> find(T data) {
        if (this.data == null) // Empty tree
            return null;
        else if (data.compareTo(this.data) == 0)
            return this;
        else if (data.compareTo(this.data) < 0)
            if (this.left == null) // Doesn't exist
                return null;
            else
                return this.left.find(data);
        else
            if (this.right == null) // Doesn't exist
                return null;
            else
                return this.right.find(data);
    }

    public void clear() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    public int getHeight() {
        if (this.data == null)
            return -1;

        int leftHeight = (this.left != null) ? this.left.getHeight() : -1;
        int rightHeight = (this.right != null) ? this.right.getHeight() : -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    private int leftHeight() {
        return this.left != null ? 1 + this.left.leftHeight() : -1; // Return 1 + the height of the next left node or -1
    }

    private int rightHeight() {
        return this.right != null ? 1 + this.right.rightHeight() : -1; // Return 1 + the height of the next right node or -1
    }


    public boolean isBalanced() {
        return Math.abs(leftHeight() - rightHeight()) <= 1;
    }

    public void print() {
        recursivePrint("", true);
    }
    
    private void recursivePrint(String indentation, boolean isLeft) {
        if (this.right != null) {
            this.right.recursivePrint(indentation + (isLeft ? "│   " : "    "), false);
        }

        System.out.println(indentation + (isLeft ? "└── " : "┌── ") + data);

        if (this.left != null) {
            this.left.recursivePrint(indentation + (isLeft ? "    " : "│   "), true);
        }
    }

}
