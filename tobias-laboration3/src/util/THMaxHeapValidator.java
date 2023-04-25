package util;

public class THMaxHeapValidator<T extends Comparable<T>> {

    /**
     * Checks if the tree is a max heap. To be max heap, the root must be larger than both children and the
     * tree must be complete, i.e. all levels must be filled except the last level, which must be filled
     * from left to right.
     *
     * @param tree tree to check
     *
     * @return true if the tree is a max heap
     */
    public boolean isMaxHeap(THBinaryTree<T> tree) {
        if (followsMaxHeapValue(tree.root) && followsMaxHeapStructure(tree.root, 0) >= 0) {
            System.out.println("Tree is a max heap");
            return true;
        } else {
            System.out.println("Tree is not a max heap");
            return false;
        }
    }

    private boolean followsMaxHeapValue(THBinaryTree.Node<T> node) {
        if (node == null) {
            return true;
        }

        if (ltLeftChild(node)) {  // left child is larger than parent
            System.out.printf("Left child (%s) is larger than parent (%s)\n", node.getLeft(), node);
            return false;
        }
        if (ltRightChild(node)) {  // right child is larger than parent
            System.out.printf("Right child (%s) is larger than parent (%s)\n", node.getRight(), node);
            return false;
        }

        return followsMaxHeapValue(node.getLeft()) && followsMaxHeapValue(node.getRight());
    }

    /**
     * Checks if the tree is complete, i.e. all levels must be filled except the last level, which must be filled
     * from left to right.
     *
     * @param node  node
     * @param level level
     *
     * @return -1 if the tree is not complete
     */
    private int followsMaxHeapStructure(THBinaryTree.Node<T> node, int level) {
        if (node == null) {
            return level;
        }

        int leftLevel = followsMaxHeapStructure(node.getLeft(), level + 1);
        int rightLevel = followsMaxHeapStructure(node.getRight(), level + 1);

        // If any subtree is not complete, the tree is not complete.
        if (leftLevel == -1 || rightLevel == -1) {
            return -1;
        }

        // If right subtree is deeper than left subtree, the tree is not complete.
        // If left subtree is deeper than right subtree by more than one level, the tree is not complete.
        if (leftLevel < rightLevel || leftLevel > rightLevel + 1) {
            System.out.println("Missing nodes.");
            return -1;
        }

        return leftLevel;
    }

    /**
     * Checks if the node is smaller than its right child.
     *
     * @param node node
     *
     * @return true if the node is smaller than its right child
     */
    private boolean ltRightChild(final THBinaryTree.Node<T> node) {
        return node.getRight() != null && node.compareTo(node.getRight()) < 0;
    }

    /**
     * Checks if the node is smaller than its left child.
     *
     * @param node node
     *
     * @return true if the node is smaller than its left child
     */
    private boolean ltLeftChild(final THBinaryTree.Node<T> node) {
        return node.getLeft() != null && node.compareTo(node.getLeft()) < 0;
    }
}
