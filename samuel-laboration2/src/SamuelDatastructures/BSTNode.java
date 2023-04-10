package SamuelDatastructures;

public class BSTNode<T extends Comparable<T>> {

    BSTNode<T> left;
    BSTNode<T> right;
    T data;

    public BSTNode(T data) {
        this.data = data;
    }

    public void insert(T data) {
        if (data.compareTo(this.data) <= 0) {
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

    public void RecursiveLevelOrderTraversal() {
        //TODO do



    }


    //TODO iterative traversals (if possible with this structure)


    public void IterativePreOrderTraversal() {
        //TODO do
    }

    public void IterativePostOrderTraversal() {
        //TODO do
    }

    public void IterativeInOrderTraversal() {
        //TODO do
    }

    public void IterativeLevelOrderTraversal() {
        var queue = new SamuelLinkedListQueue<BSTNode<T>>();
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

    public boolean contains(T data) {
        if (data.compareTo(this.data) == 0)
            return true;
        else if (data.compareTo(this.data) < 0)
            if (this.left == null)
                return false;
            else
                return this.left.contains(data);
        else
            if (this.right == null)
                return false;
            else
                return this.right.contains(data);
    }

    public void find(BSTNode<T> node) {
        //TODO do
    }

    public int getHeight() {
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
