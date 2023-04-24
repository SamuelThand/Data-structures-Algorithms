package Q1;

import SamuelDatastructures.BinaryTreeNode;

public class Q1 {

    public static void main(String[] args) {

        var tree1 = new BinaryTreeNode<>(50);

        tree1.insert(48);
        tree1.insert(52);
        tree1.insert(46);
        tree1.insert(51);
        tree1.insert(53);
        System.out.println("The tree is not complete and each node is not >= its child");
        tree1.print();

        System.out.printf("Is a complete tree: %b\n", tree1.isCompleteTree());
        System.out.printf("Has the max-heap property for all nodes: %b\n", tree1.hasMaxHeapProperty());
        System.out.printf("Is a max-heap: %b\n", tree1.isMaxHeap());
        System.out.println();
        System.out.println();


        var tree2 = new BinaryTreeNode<>(50);

        tree2.insert(48);
        tree2.insert(52);
        tree2.insert(46);
        tree2.insert(49);
        tree2.insert(51);
        tree2.insert(53);
        System.out.println("The tree is complete but each node is not >= its child");
        tree2.print();

        System.out.printf("Is a complete tree: %b\n", tree2.isCompleteTree());
        System.out.printf("Has the max-heap property for all nodes: %b\n", tree2.hasMaxHeapProperty());
        System.out.printf("Is a max-heap: %b\n", tree2.isMaxHeap());
        System.out.println();
        System.out.println();

        var tree3 = new BinaryTreeNode<>(53);

        tree3.insert(52);
        tree3.insert(51);
        tree3.insert(50);
        tree3.insert(49);
        tree3.insert(48);
        tree3.insert(46);
        System.out.println("Each node is >= its child, but the tree is not complete");
        tree3.print();

        System.out.printf("Is a complete tree: %b\n", tree3.isCompleteTree());
        System.out.printf("Has the max-heap property for all nodes: %b\n", tree3.hasMaxHeapProperty());
        System.out.printf("Is a max-heap: %b\n", tree3.isMaxHeap());
        System.out.println();
        System.out.println();

        var tree4 = new BinaryTreeNode<>(56);

        tree4.left = new BinaryTreeNode<>(52);
        tree4.right = new BinaryTreeNode<>(54);
        tree4.left.left = new BinaryTreeNode<>(50);
        tree4.left.right = new BinaryTreeNode<>(5);
        tree4.right.left = new BinaryTreeNode<>(16);
        tree4.right.right = new BinaryTreeNode<>(20);
        System.out.println("The tree is complete, and each node is >= its child.");
        tree4.print();

        System.out.printf("Is a complete tree: %b\n", tree4.isCompleteTree());
        System.out.printf("Has the max-heap property for all nodes: %b\n", tree4.hasMaxHeapProperty());
        System.out.printf("Is a max-heap: %b\n", tree4.isMaxHeap());
        System.out.println();
        System.out.println();
    }

}
