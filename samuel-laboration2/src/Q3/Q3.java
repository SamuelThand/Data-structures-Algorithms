package Q3;

import SamuelDatastructures.BSTNode;

public class Q3 {

        public static void main(String[] args) {

                var tree = new BSTNode<>('A');

                System.out.println("Iterative Level order traversal:");
                tree.iterativeLevelOrderTraversal();
                System.out.println();

                System.out.println("Recursive Level order traversal:");
                tree.recursiveLevelOrderTraversal();
                System.out.println();

                System.out.println("Iterative Pre order traversal:");
                tree.iterativePreOrderTraversal();
                System.out.println();

                System.out.println("Recursive Pre order traversal:");
                tree.recursivePreOrderTraversal();
                System.out.println();

                System.out.println("Iterative postorder traversal:");
                tree.iterativePostOrderTraversal();
                System.out.println();

                System.out.println("Recursive postorder traversal:");
                tree.recursivePostOrderTraversal();

                System.out.println("Iterative inorder traversal:");
                tree.iterativeInOrderTraversal();
                System.out.println();

                System.out.println("Recursive inorder traversal:");
                tree.recursiveInOrderTraversal();

                System.out.println("contains 30");
                System.out.println();


                System.out.println("Recursive preorder traversal:");
                tree.recursivePreOrderTraversal();

                System.out.println("Recursive inorder traversal:");
                tree.recursiveInOrderTraversal();
        }
}

