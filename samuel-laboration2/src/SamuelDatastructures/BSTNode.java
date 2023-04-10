package SamuelDatastructures;

public class BSTNode<T extends Comparable<T>> {

    BSTNode<T> left;
    BSTNode<T> right;
    T data;

    public BSTNode(T data) {
        this.data = data;
    }

    public void insert(T data) {
        if (this.data == null)
            this.data = data;

        else if (data.compareTo(this.data) <= 0) {
            if (this.left == null)
                this.left = new BSTNode<>(data);
            else
                this.left.insert(data);

        } else {
            if (this.right == null)
                this.right = new BSTNode<>(data);
            else
                this.right.insert(data);
        }
    }

    public void remove(T data) {
        //TODO do


    }

    public void recursivePreOrderTraversal() {
        System.out.println(this.data);
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
        System.out.println(this.data);
    }

    public void recursiveInOrderTraversal() {
        if (this.left != null)
            this.left.recursiveInOrderTraversal();
        System.out.println(this.data);
        if (this.right != null)
            this.right.recursiveInOrderTraversal();
    }

    public void recursiveLevelOrderTraversal() {
        for (int i = 0; i < getHeight(); i++)
            printNodesForDepth(i);
    }

    private void printNodesForDepth(int depth) {
        if (depth == 0)
            System.out.println(this.data);
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
            System.out.println(node.data);
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

        while (!stack.isEmpty()) {
            var node = stack.pop();
            nodesInReverse.enqueue(node);
            if (node.left != null)
                stack.enqueue(node.left);
            if (node.right != null)
                stack.enqueue(node.right);
        }

        while (!nodesInReverse.isEmpty())
            System.out.println(nodesInReverse.pop().data);
    }

    public void iterativeInOrderTraversal() {
        var stack = new SamuelLinkedListStackQueue<BSTNode<T>>();
        var node = this;

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.enqueue(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.println(node.data);
                node = node.right;
            }
        }
    }

    public void iterativeLevelOrderTraversal() {
        var queue = new SamuelLinkedListStackQueue<BSTNode<T>>();
        queue.enqueue(this);

        while (!queue.isEmpty()) {
            var node = queue.deque();
            System.out.println(node.data);
            if (node.left != null)
                queue.enqueue(node.left);
            if (node.right != null)
                queue.enqueue(node.right);
        }
    }

    public BSTNode<T> find(T data) {
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

    public int getHeight() {
        if (this.data == null)
            return -1;

        int leftHeight = this.leftHeight();
        int rightHeight = this.rightHeight();

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

}
