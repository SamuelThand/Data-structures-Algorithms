package Q2;

import SamuelDatastructures.BSTNode;

public class Q2 {

    public static void main(String[] args) {
        System.out.println("lab 2 Q2");

        var tree = new BSTNode<>(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Iterative Level order traversal:");
        tree.IterativeLevelOrderTraversal();

        System.out.println("contains 30");
        System.out.println(tree.contains(30));

//        System.out.println("Recursive preorder traversal:");
//        tree.recursivePreOrderTraversal();

//        System.out.println("Recursive postorder traversal:");
//        tree.recursivePostOrderTraversal();
//
//        System.out.println("Recursive inorder traversal:");
//        tree.recursiveInOrderTraversal();

    }
}