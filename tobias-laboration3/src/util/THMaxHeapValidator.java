package util;

public class THMaxHeapValidator<T extends Comparable<T>> {

    public boolean isMaxHeap(THBinaryTree<T> tree) {
        if (!tree.checkBalance()) {
            System.out.println("Tree is not balanced");
            return false;
        } else if (isMaxHeap(tree.root)) {
            System.out.println("Tree is a max heap");
            return true;
        } else {
            System.out.println("Tree is not a max heap");
            return false;
        }
    }

    private boolean isMaxHeap(THBinaryTree.Node<T> node) {
        if (node == null) {
            return true;
        } if (ltLeftChild(node)) {
            System.out.printf("Left child (%s) is larger than parent (%s)\n", node.left, node);
            return false;
        } if (ltRightChild(node)) {
            System.out.printf("Right child (%s) is larger than parent (%s)\n", node.right, node);
            return false;
        }

        return isMaxHeap(node.left) && isMaxHeap(node.right);
    }

    private boolean ltRightChild(final THBinaryTree.Node<T> node) {
        return node.right != null && node.compareTo(node.right) < 0;
    }

    private boolean ltLeftChild(final THBinaryTree.Node<T> node) {
        return node.left != null && node.compareTo(node.left) < 0;
    }
}
