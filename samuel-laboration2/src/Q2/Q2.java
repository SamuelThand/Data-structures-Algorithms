package Q2;

import SamuelDatastructures.BSTNode;

public class Q2 {

    public static void main(String[] args) {

        System.out.println("Tree:");

        var tree = new BSTNode<>('M');
        tree.insert('O');
        tree.insert('T');
        tree.insert('H');
        tree.insert('E');
        tree.insert('R');

        tree.print();
        System.out.printf("Balanced: %s\n", tree.isBalanced());
        System.out.printf("Height: %s\n", tree.getHeight());

        tree.clear();

        tree.insert('T');
        tree.insert('H');
        tree.insert('E');
        tree.insert('R');
        tree.insert('M');
        tree.insert('O');

        tree.print();
        System.out.printf("Balanced: %s\n", tree.isBalanced());
        System.out.printf("Height: %s\n", tree.getHeight());

        tree.clear();

        tree.insert('E');
        tree.insert('H');
        tree.insert('M');
        tree.insert('O');
        tree.insert('R');
        tree.insert('T');

        tree.print();
        System.out.printf("Balanced: %s\n", tree.isBalanced());
        System.out.printf("Height: %s\n", tree.getHeight());



//
//        System.out.println("Tree:");
//
//        var tree = new BSTNode<>(50);
//        tree.insert(30);
//        tree.insert(20);
//        tree.insert(40);
//        tree.insert(70);
//        tree.insert(60);
//        tree.insert(80);
//        tree.insert(81);
//        tree.insert(82);
//        tree.insert(83);
//        tree.insert(86);
//        tree.insert(1);
//
//        tree.print();
//        System.out.printf("Balanced: %s\n", tree.isBalanced());
//        System.out.printf("Height: %s\n", tree.getHeight());

//        System.out.println("Iterative Level order traversal:");
//        tree.iterativeLevelOrderTraversal();
//        System.out.println();
//
//        System.out.println("Recursive Level order traversal:");
//        tree.recursiveLevelOrderTraversal();
//        System.out.println();

//        System.out.println("Iterative Pre order traversal:");
//        tree.iterativePreOrderTraversal();
//        System.out.println();
//
//        System.out.println("Recursive Pre order traversal:");
//        tree.recursivePreOrderTraversal();
//        System.out.println();
//
//        System.out.println("Iterative postorder traversal:");
//        tree.iterativePostOrderTraversal();
//        System.out.println();
//
//        System.out.println("Recursive postorder traversal:");
//        tree.recursivePostOrderTraversal();

//        System.out.println("Iterative inorder traversal:");
//        tree.iterativeInOrderTraversal();
//        System.out.println();
//
//        System.out.println("Recursive inorder traversal:");
//        tree.recursiveInOrderTraversal();

//        System.out.println("contains 30");
//        System.out.println(tree.find(30));
//        System.out.println();
//
//
//        System.out.println("Recursive preorder traversal:");
//        tree.recursivePreOrderTraversal();
//
////
//        System.out.println("Recursive inorder traversal:");
//        tree.recursiveInOrderTraversal();

    }
}