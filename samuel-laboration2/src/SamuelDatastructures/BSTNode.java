package SamuelDatastructures;

public class BSTNode<T extends Comparable<T>> {

    BSTNode<T> left;
    BSTNode<T> right;
    T data;

    BSTNode(T data) {
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

    public void RecursivePreOrderTraversal() {
        System.out.println(this.data);
        if (this.left != null)
            this.left.RecursiveInOrderTraversal();
        if (this.right != null)
            this.right.RecursiveInOrderTraversal();
    }

    public void RecursivePostOrderTraversal() {
        if (this.left != null)
            this.left.RecursiveInOrderTraversal();
        if (this.right != null)
            this.right.RecursiveInOrderTraversal();
        System.out.println(this.data);
    }

    public void RecursiveInOrderTraversal() {
        if (this.left != null)
            this.left.RecursiveInOrderTraversal();
        System.out.println(this.data);
        if (this.right != null)
            this.right.RecursiveInOrderTraversal();
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
        // TODO Implement a new better queue with good big-O
        // TODO Use queue for traversing in leveled order
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

    public boolean isBalanced() {
        return true;
    }

    public void print() {
        //TODO do
    }

}
